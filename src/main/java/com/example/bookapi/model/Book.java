package com.example.bookapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer bookId;
	
	private String bookTitle;
	private Integer publishedYear;
	private String authorName;
	
	private String genre;
	private Integer numberOfPages;
	
	public Book() {
	}
	
	public Integer getBookId() {
		return bookId;
	}
	
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	
	public String getBookTitle() {
		return bookTitle;
	}
	
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	
	public Integer getPublishedYear() {
		return publishedYear;
	}
	
	public void setPublishedYear(Integer publishedYear) {
		this.publishedYear = publishedYear;
	}
	
	public String getAuthorName() {
		return authorName;
	}
	
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	
	public String getGenre() {
		return genre;
	}
	
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public Integer getNumberOfPages() {
		return numberOfPages;
	}
	
	public void setNumberOfPages(Integer numberOfPages) {
		this.numberOfPages = numberOfPages;
	}
	
	@Override
	public String toString() {
		return """
    	Book:
  		Id: %d
  		Book Title: %s
  		Published Year: %d
  		Author Name: %s
  		Genre: %s
  		Number of Pages: %d
		""".formatted(this.getBookId(), this.getBookTitle(), this.getPublishedYear(), this.getAuthorName(), this.getGenre(), this.getNumberOfPages());
	}
}
