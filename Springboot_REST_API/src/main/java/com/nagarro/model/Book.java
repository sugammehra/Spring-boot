package com.nagarro.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "books_info")
public class Book {
	@Id
	@Column(name="book_id")
	private String bookId;
//	
	@Column(name="book_name")
	private String bookName;
	
	
	@ManyToOne()
	@JoinColumn(name="book_author")
	private Author bookAuthor;
//	private String bookAuthor;
	

	private String date;
	
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book(String bookId, String bookName, Author bookAuthor, String date) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.date = date;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public Author getBookAuthor() {
		return bookAuthor;
	}
	public void setBookAuthor(Author bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
}
