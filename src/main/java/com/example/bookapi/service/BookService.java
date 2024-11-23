package com.example.bookapi.service;

import com.example.bookapi.model.Book;
import com.example.bookapi.payload.request.BookRequest;
import com.example.bookapi.payload.response.MessageResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface BookService {
	MessageResponse addBook(BookRequest bookRequest);
	
	Optional<Book> getBookByBookId(Integer bookId);
	
	Optional<Book> getBookByBookTitle(String bookTitle);
	
	List<Book> getBooksByGenre(String genre);
	
	List<Book> getBooksByPublishedYearBetween(Integer startYear, Integer endYear);
	
	List<Book> getBooksByPublishedYearAfter(Integer publishedYear);
	
	List<Book> getBooksByPublishedYearBefore(Integer publishedYear);
	
	List<Book> getBooksByAuthorName(String authorName);
	
	List<Book> getAllBooks();
	
	void deleteBookByBookTitle(String bookTitle);
	
	void deleteBookByBookId(Integer bookId);
	
	void deleteBookByBookIds(Integer... bookIds);
}
