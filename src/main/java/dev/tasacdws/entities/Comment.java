//package dev.tasacdws.entities;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.Table;
//
//@Entity
//@Table(name="comment")
//public class Comment {
//	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "c_id")
//	private int id;
//	
//	@Column(name = "comment")
//	private String comment;
//	
//	@Column(name = "rating")
//	private int rating;
//	
//	@Column(name = "u_id")
//	private int u_id;
//	
//	@Column(name = "s_id")
//	private int s_id;
//	
//
//
//	public Comment() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//
//	public Comment(int id, int rating, int u_id, int s_id) {
//		super();
//		this.id = id;
//		this.rating = rating;
//		this.u_id = u_id;
//		this.s_id = s_id;
//	}
//
//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public int getRating() {
//		return rating;
//	}
//
//	public void setRating(int rating) {
//		this.rating = rating;
//	}
//
//	public int getU_id() {
//		return u_id;
//	}
//
//	public void setU_id(int u_id) {
//		this.u_id = u_id;
//	}
//
//	public int getS_id() {
//		return s_id;
//	}
//
//	public void setS_id(int s_id) {
//		this.s_id = s_id;
//	}
//
//	@Override
//	public String toString() {
//		return "comment [id=" + id + ", rating=" + rating + ", u_id=" + u_id + ", s_id=" + s_id + "]";
//	}
//	
//	
//
//}
