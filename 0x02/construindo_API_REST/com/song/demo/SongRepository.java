package com.song.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class SongRepository {
	private List<Song> list = new ArrayList<Song>();

	public List<Song> getAllSongs() {
		return list;
	}

	public Song getSongById(Integer id) {
		for (Song song : getAllSongs()) {
			if (song.getId().equals(id)) {
				return song;
			}
		}

		return null;
	}

	public void addSong(Song s) {
		list.add(s);
	}

	public void updateSong(Song s) {
		for (Song song : getAllSongs()) {
			if (song.getId().equals(s.getId())) {
				list.remove(song);
				list.add(s);
			}
		}
	}

	public void removeSong(Song s) {
		list.remove(s);
	}

	public void addList(List<Song> listOfSongs) {
		list.addAll(listOfSongs);
	}
}