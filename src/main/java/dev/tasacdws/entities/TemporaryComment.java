package dev.tasacdws.entities;



public class TemporaryComment {
	
	private int id;
	private String comment;
	private int rating;
	private int user;
	private int song;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public int getUser() {
		return user;
	}
	public void setUser(int user) {
		this.user = user;
	}
	public int getSong() {
		return song;
	}
	public void setSong(int song) {
		this.song = song;
	}
	public TemporaryComment(int id, String comment, int rating, int user, int song) {
		super();
		this.id = id;
		this.comment = comment;
		this.rating = rating;
		this.user = user;
		this.song = song;
	}
	public TemporaryComment() {
		super();
	}
	
	@Override
	public String toString() {
		return "TemporaryComment [id=" + id + ", comment=" + comment + ", rating=" + rating + ", user=" + user
				+ ", song=" + song + "]";
	}
	
	
	
	
}
	
