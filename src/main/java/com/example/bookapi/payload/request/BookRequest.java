package com.example.bookapi.payload.request;

import jakarta.annotation.Nonnull;

public class BookRequest {
	
	@Nonnull
	private String bookTitle, genre;
	
	@Nonnull
	private Integer publishedYear, numberOfPages;
	
	@Nonnull
	private String authorName;
	
	public BookRequest() {
	}
	
	@Nonnull
	public String getBookTitle() {
		return bookTitle;
	}
	
	public void setBookTitle(@Nonnull String bookTitle) {
		this.bookTitle = bookTitle;
	}
	
	@Nonnull
	public String getGenre() {
		return genre;
	}
	
	public void setGenre(@Nonnull String genre) {
		this.genre = genre;
	}
	
	@Nonnull
	public Integer getPublishedYear() {
		return publishedYear;
	}
	
	public void setPublishedYear(@Nonnull Integer publishedYear) {
		this.publishedYear = publishedYear;
	}
	
	@Nonnull
	public Integer getNumberOfPages() {
		return numberOfPages;
	}
	
	public void setNumberOfPages(@Nonnull Integer numberOfPages) {
		this.numberOfPages = numberOfPages;
	}
	
	@Nonnull
	public String getAuthorName() {
		return authorName;
	}
	
	public void setAuthorName(@Nonnull String authorName) {
		this.authorName = authorName;
	}
}
