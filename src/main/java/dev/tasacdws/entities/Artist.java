package dev.tasacdws.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="artist")
public class Artist {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "a_id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;
	
	@OneToMany(mappedBy = "artist")
	private Set<Song> songs;

	public Artist() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Artist(int id, String name, String username, String password, Set<Song> songs) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.password = password;
		this.songs = songs;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Song> getSongs() {
		return songs;
	}

	public void setSongs(Set<Song> songs) {
		this.songs = songs;
	}

	@Override
	public String toString() {
		return "Artist [id=" + id + ", name=" + name + ", username=" + username + ", password=" + password + ", songs="
				+ songs + "]";
	}
	
	

}
