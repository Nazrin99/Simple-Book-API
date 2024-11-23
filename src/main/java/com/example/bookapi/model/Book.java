package com.example.bookapi.model;

import jakarta.persistence.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.Year;
import java.time.YearMonth;
import java.util.Calendar;
import java.util.Date;

@Entity
public class Book {
	private static Logger logger = LoggerFactory.getLogger(Book.class);
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer bookId;
	
	
	@Column(nullable = false, unique = true)
	private String bookTitle;
	
	@Column(nullable = false)
	private Integer publishedYear;
	
	@Column(columnDefinition = "varchar(255) default 'None'", nullable = false)
	private String genre;
	
	@Column(nullable = false)
	private Integer numberOfPages;
	
	@Column(nullable = false)
	private String authorName;
	

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
	
	public String getAuthorName() {
		return authorName;
	}
	
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
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
	
	// Entity lifecycle hooks
	@PrePersist
	public void addNewUserAttempt() {
		logger.info(String.format("Attempting to add new book with title: %s", this.getBookTitle()));
	}
	
	@PostPersist
	public void newUserAdded() {
		logger.info(String.format("%s added to the database with ID: %d", this.getBookTitle(), this.getBookId()));
	}
}
