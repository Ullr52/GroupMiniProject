/**
 * Avon (Andres) Mata - ammata & John Ord
 * CIS175 JAVA II
 * Group Mini Project
 * Completed on: Mar 1, 2022
 */
package model;

import javax.persistence.*;

@Entity
@Table(name="bookslist")
public class Bookslist {
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;
	//Which one is One-To-Many and Many-To-One?
	@Column(name="Publisher")
	private String publisher;
	@Column(name="Title")
	private String title;
	@Column(name="Genre")
	private String genre;
	
	public Bookslist() {
		super();
		this.id = 0;
		this.publisher = null;
		this.title = null;
		this.genre = null;
	}
	
	public Bookslist(int id, String p, String t, String g) {
		super();
		this.id = id;
		this.publisher = p;
		this.title = t;
		this.genre = g;
	}
	
	public Bookslist(String p, String t, String g) {
		super();
		this.publisher = p;
		this.title = t;
		this.genre = g;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	@Override
	public String toString() {
		return "BooksList: [id: " + this.id + ", Publisher: " + this.publisher + ", Title: " + this.title + ", Genre: " + this.genre + "]";
	}

}
