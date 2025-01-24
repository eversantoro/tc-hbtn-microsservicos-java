package com.example.user.exception;

public class UserErrorResponse {
    private int status;
    private String message;

    // Construtor padrão
    public UserErrorResponse() {}

    // Construtor com parâmetros
    public UserErrorResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }

    // Getters e Setters
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
