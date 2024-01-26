package com.example.bookapi.service;

import com.example.bookapi.model.Book;
import com.example.bookapi.payload.request.BookRequest;
import com.example.bookapi.payload.response.MessageResponse;
import com.example.bookapi.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService{
	
	@Autowired
	BookRepository bookRepository;
	
	@Override
	public MessageResponse addBook(BookRequest bookRequest) {
		Book book = new Book();
		book.setBookTitle(bookRequest.getBookTitle());
		book.setAuthorName(bookRequest.getAuthorName());
		book.setGenre(bookRequest.getGenre());
		book.setPublishedYear(bookRequest.getPublishedYear());
		book.setNumberOfPages(bookRequest.getNumberOfPages());
		
		Book savedBook = bookRepository.save(book);
		
		return new MessageResponse("Book saved successfully in database with ID: %d".formatted(savedBook.getBookId()));
	}
	
	@Override
	public Optional<Book> getBookByBookId(Integer bookId) {
		return bookRepository.findById(bookId);
 	}
	
	@Override
	public Optional<Book> getBookByBookTitle(String bookTitle) {
		return Optional.ofNullable(bookRepository.getBookByBookTitle(bookTitle));
	}
	
	@Override
	public List<Book> getBooksByGenre(String genre) {
		return bookRepository.getBooksByGenre(genre);
	}
	
	@Override
	public List<Book> getBooksByPublishedYearBetween(Integer startYear, Integer endYear) {
		return bookRepository.getBooksByPublishedYearBetween(startYear, endYear);
	}
	
	@Override
	public List<Book> getBooksByPublishedYearAfter(Integer publishedYear) {
		return bookRepository.getBooksByPublishedYearAfter(publishedYear);
	}
	
	@Override
	public List<Book> getBooksByPublishedYearBefore(Integer publishedYear) {
		return bookRepository.getBooksByPublishedYearBefore(publishedYear);
	}
	
	@Override
	public List<Book> getBooksByAuthorName(String authorName) {
		return bookRepository.getBooksByAuthorName(authorName);
	}
	
	@Override
	public void deleteBookByBookTitle(String bookTitle) {
		bookRepository.deleteBookByBookTitle(bookTitle);
	}
	
	@Override
	public void deleteBookByBookId(Integer bookId) {
		bookRepository.deleteById(bookId);
	}
	
	@Override
	public void deleteBookByBookIds(Integer... bookIds) {
		bookRepository.deleteAllByIdInBatch(Arrays.stream(bookIds).toList());
	}
	
	@Override
	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}
}
