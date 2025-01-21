package com.example.jpah2demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;
	
	
	@PostMapping("/addClient")
	public ResponseEntity<Cliente> addClient(@RequestBody Cliente cliente) {
		Cliente customerCreated = clienteRepository.save(cliente);
		return ResponseEntity.status(HttpStatus.CREATED).body(customerCreated);
	}
	
	@GetMapping("/findAllClients")
	public ResponseEntity<List<Cliente>> findAllClients() {
		List<Cliente> clientes = clienteRepository.findAll();
		return ResponseEntity.ok(clientes);
	}
	
	@GetMapping("/findClientById/{id}")
	public ResponseEntity<Cliente> findClientById(@PathVariable("id") Long idClient) {
		Optional<Cliente> customerCreated = clienteRepository.findById(idClient);
		return ResponseEntity.status(HttpStatus.CREATED).body(customerCreated.get());
	}
		
	@DeleteMapping("/removeClientById/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerCliente(@PathVariable("id") Long idClient){
		clienteRepository.findById(idClient)
						.map(cliente -> {
							clienteRepository.deleteById(cliente.getId());
							return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado."));
    }
	
	@PutMapping("/updateClientById/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCliente(@PathVariable("id") Long id, @RequestBody Cliente cliente){
		Optional<Cliente> client = clienteRepository.findById(id);	
		if (client.get() != null) {
			clienteRepository.delete(client.get());
			clienteRepository.save(cliente);
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado.");
		}
    }

}
