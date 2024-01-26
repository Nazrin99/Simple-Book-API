package com.example.bookapi.payload.request;

import jakarta.annotation.Nullable;

public class BookRequest {
	@Nullable
	private String bookTitle, authorName, genre;
	
	@Nullable
	private Integer publishedYear, numberOfPages;
	
	public BookRequest() {
	}
	
	@Nullable
	public String getBookTitle() {
		return bookTitle;
	}
	
	public void setBookTitle(@Nullable String bookTitle) {
		this.bookTitle = bookTitle;
	}
	
	@Nullable
	public String getAuthorName() {
		return authorName;
	}
	
	public void setAuthorName(@Nullable String authorName) {
		this.authorName = authorName;
	}
	
	@Nullable
	public String getGenre() {
		return genre;
	}
	
	public void setGenre(@Nullable String genre) {
		this.genre = genre;
	}
	
	@Nullable
	public Integer getPublishedYear() {
		return publishedYear;
	}
	
	public void setPublishedYear(@Nullable Integer publishedYear) {
		this.publishedYear = publishedYear;
	}
	
	@Nullable
	public Integer getNumberOfPages() {
		return numberOfPages;
	}
	
	public void setNumberOfPages(@Nullable Integer numberOfPages) {
		this.numberOfPages = numberOfPages;
	}
}
