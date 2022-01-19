package com.example.book;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity

public class Book {
	private @Id @GeneratedValue Long id;
	private String title;
	private String author;
	
	
	
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	

	

	Book() {}
	
	public Book(String title, String author, int copies) {
		super();
		this.title = title;
		this.author = author;
		
	}  
}	