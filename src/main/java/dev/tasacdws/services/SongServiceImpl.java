package dev.tasacdws.services;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import dev.tasacdws.entities.Song;
import dev.tasacdws.repositories.SongRepository;

@Component
@Service
public class SongServiceImpl implements SongService {
	
	@Autowired
	SongRepository sr;

	@Override
	public Song createSong(Song song) {
		song = sr.save(song);
		return song;
	}

	@Override
	public Song getSongById(int id) {
		Song song = sr.findById(id).get();
		return song;
	}

	@Override
	public Set<Song> getAllSongs() {
		Set<Song> songs = new HashSet<Song>((Collection<? extends Song>) sr.findAll());
		return songs;
	}

	@Override
	public Set<Song> getAllSongsByArtistId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Song updateSong(Song song) {
		song = sr.save(song);
		return song;
	}

	@Override
	public boolean deleteSong(Song song) {
		try {
			sr.delete(song);
			return true;
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return false;
		}
	}

}
