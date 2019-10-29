package dev.tasacdws.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="song")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Song {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "s_id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name ="a_id")
	private Artist artist;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "releaseDate")
	private long releaseDate;
	
	@Column(name = "albumName")
	private String albumName;
	
	@Column(name = "inAlbum")
	private int inAlbum;
	
	@Column(name = "rating")
	private int rating;
	
	@Column(name = "link")
	private String link;
	
	@OneToMany(mappedBy = "song", fetch = FetchType.EAGER)
	private Set<Comment> comments;
	
	

	public Song() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Song(int id, Artist artist, String name, long releaseDate, String albumName, int inAlbum, int rating,
			String link, Set<Comment> comments) {
		super();
		this.id = id;
		this.artist = artist;
		this.name = name;
		this.releaseDate = releaseDate;
		this.albumName = albumName;
		this.inAlbum = inAlbum;
		this.rating = rating;
		this.link = link;
		this.comments = comments;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public Artist getArtist() {
		return artist;
	}



	public void setArtist(Artist artist) {
		this.artist = artist;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public long getReleaseDate() {
		return releaseDate;
	}



	public void setReleaseDate(long releaseDate) {
		this.releaseDate = releaseDate;
	}



	public String getAlbumName() {
		return albumName;
	}



	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}



	public int getInAlbum() {
		return inAlbum;
	}



	public void setInAlbum(int inAlbum) {
		this.inAlbum = inAlbum;
	}



	public int getRating() {
		return rating;
	}



	public void setRating(int rating) {
		this.rating = rating;
	}



	public String getLink() {
		return link;
	}



	public void setLink(String link) {
		this.link = link;
	}







	public Set<Comment> getComments() {
		return comments;
	}



	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}



	@Override
	public String toString() {
		return "Song [id=" + id + ", artist=" + artist + ", name=" + name + ", releaseDate=" + releaseDate
				+ ", albumName=" + albumName + ", inAlbum=" + inAlbum + ", rating=" + rating + ", link=" + link
				+ ", comments=" + comments + "]";
	}
	
	

}
