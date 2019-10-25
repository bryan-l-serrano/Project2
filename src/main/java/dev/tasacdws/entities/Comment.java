package dev.tasacdws.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="comment")
public class Comment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "c_id")
	private int id;
	
	@Column(name = "comment")
	private String comment;
	
	@Column(name = "rating")
	private int rating;
	
	@ManyToOne
	@JoinColumn(name = "u_id")
	private Users user;
	
	@ManyToOne
	@JoinColumn(name = "s_id")
	private Song song;
	


	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Comment(int id, String comment, int rating, Users user, Song song) {
		super();
		this.id = id;
		this.comment = comment;
		this.rating = rating;
		this.user = user;
		this.song = song;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Song getSong() {
		return song;
	}

	public void setSong(Song song) {
		this.song = song;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", comment=" + comment + ", rating=" + rating + ", user=" + user + ", song=" + song
				+ "]";
	}
	
	

}
