package dev.tasacdws.entities;

public class TemporarySong {
	
	private int id;
	
	private int artistId;
	private String name;
	private long releaseDate;
	private String albumName;
	private int inAlbum;
	private int rating;
	private String link;
	private String albumArt;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getArtistId() {
		return artistId;
	}
	public void setArtistId(int artistId) {
		this.artistId = artistId;
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
	public String getAlbumArt() {
		return albumArt;
	}
	public void setAlbumArt(String albumArt) {
		this.albumArt = albumArt;
	}
	public TemporarySong() {
		super();
	}
	public TemporarySong(int id, int artistId, String name, long releaseDate, String albumName, int inAlbum, int rating,
			String link, String albumArt) {
		super();
		this.id = id;
		this.artistId = artistId;
		this.name = name;
		this.releaseDate = releaseDate;
		this.albumName = albumName;
		this.inAlbum = inAlbum;
		this.rating = rating;
		this.link = link;
		this.albumArt = albumArt;
	}
	
	

}
