package dev.tasacdws.services;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import dev.tasacdws.entities.Song;
import dev.tasacdws.entities.TemporarySong;
import dev.tasacdws.repositories.ArtistRepository;
import dev.tasacdws.repositories.SongRepository;

@Component
@Service
public class SongServiceImpl implements SongService {
	
	@Autowired
	SongRepository sr;
	
	@Autowired
	ArtistRepository ar;

	@Override
	public Song createSong(TemporarySong song) {
		Song newSong = new Song();
		newSong.setId(song.getId());
		newSong.setArtist(ar.findById(song.getArtistId()).get());
		newSong.setName(song.getName());
		newSong.setReleaseDate(song.getReleaseDate());
		newSong.setAlbumName(song.getAlbumName());
		newSong.setInAlbum(song.getInAlbum());
		newSong.setRating(song.getRating());
		newSong.setLink(song.getLink());
		newSong.setAlbumArt(song.getAlbumArt());
		newSong = sr.save(newSong);
		return newSong;
	}

	@Override
	public Song getSongById(int id) {
		Song song = sr.findById(id).get();
		return song;
	}

	@Override
	public Set<TemporarySong> getAllSongs() {
		Set<Song> songs = new HashSet<Song>((Collection<? extends Song>) sr.findAll());
		Set<TemporarySong> ts = new HashSet<TemporarySong>();
		
		for(Song s : songs) {
			TemporarySong newSong = new TemporarySong();
			newSong.setId(s.getId());
			newSong.setArtistId(s.getArtist().getId());
			newSong.setName(s.getName());
			newSong.setReleaseDate(s.getReleaseDate());
			newSong.setAlbumName(s.getAlbumName());
			newSong.setInAlbum(s.getInAlbum());
			newSong.setRating(s.getRating());
			newSong.setLink(s.getLink());
			newSong.setAlbumArt(s.getAlbumArt());
			ts.add(newSong);
		}
		
		return ts;
	}

	@Override
	public Set<Song> getAllSongsByArtistId(int id) {
		Set<Song> songs = ar.findById(id).get().getSongs();
		System.out.println(songs);
		return songs;
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

	@Override
	public Set<Song> getAllSongsByName(String name) {
		Set<Song> songs = sr.findAllByName(name);
		return songs;
	}

}
