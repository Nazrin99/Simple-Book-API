package com.example.bookapi.web;

import com.example.bookapi.model.Book;
import com.example.bookapi.payload.request.BookRequest;
import com.example.bookapi.payload.response.MessageResponse;
import com.example.bookapi.service.BookService;
import io.swagger.annotations.ApiResponses;
import io.swagger.models.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/book")
@ApiResponses(value = {
		@io.swagger.annotations.ApiResponse(code = 400, message = "This is a bad request, please follow the API documentation for the proper request format"),
		@io.swagger.annotations.ApiResponse(code = 401, message = "Due to security constraints, your access request cannot be authorized"),
		@io.swagger.annotations.ApiResponse(code = 500, message = "The server is down. Please bear with us."),
})
public class BookController {
	@Autowired
	BookService bookService;
	
	@PostMapping("/add")
	public ResponseEntity<MessageResponse> addBook(@RequestBody BookRequest bookRequest) {
		MessageResponse messageResponse = bookService.addBook(bookRequest);
		return ResponseEntity.status(HttpStatus.CREATED).body(messageResponse);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity getBookByBookId(@PathVariable("id") Integer bookId) {
		Optional<Book> book = bookService.getBookByBookId(bookId);
		if (book.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new MessageResponse("Book with ID: %d not found!".formatted(bookId)));
		}
		else {
			return ResponseEntity.ok(book.get());
		}
	}
	
	@GetMapping("/find/all")
	public ResponseEntity getAllBooks() {
		List<Book> books = bookService.getAllBooks();
		if (books.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new MessageResponse("No books exist in the database!"));
		}
		else {
			return ResponseEntity.ok(books);
		}
	}
	
	@GetMapping("/find/title/{title}")
	public ResponseEntity getBookByBookTitle(@PathVariable("title") String bookTitle) {
		Optional<Book> book = bookService.getBookByBookTitle(bookTitle);
		if (book.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new MessageResponse("Book with title: %s does not exist!".formatted(bookTitle)));
		}
		else {
			return ResponseEntity.ok(book.get());
		}
	}
	
	@GetMapping("/find/genre/{genre}")
	public ResponseEntity getBooksByGenre(@PathVariable("genre") String genre) {
		List<Book> books = bookService.getBooksByGenre(genre);
		if (books.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new MessageResponse("No books found under the genre: %s".formatted(genre)));
		}
		else {
			return ResponseEntity.ok(books);
		}
	}
	
	@GetMapping("/find/author/{author}")
	public ResponseEntity getBooksByAuthorName(@PathVariable("author") String author) {
		List<Book> books = bookService.getBooksByAuthorName(author);
		if (books.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new MessageResponse("No books found by author: %s".formatted(author)));
		}
		else {
			return ResponseEntity.ok(books);
		}
	}
	
	@GetMapping("/find/year")
	public ResponseEntity getBooksByPublishedYear(
			@RequestParam(value = "startYear", required = false) Optional<Integer> startYear,
			@RequestParam(value = "endYear", required = false) Optional<Integer> endYear
	) {
		List<Book> books = new ArrayList<>();
		if (startYear.isPresent() && endYear.isPresent()) {
			List<Book> booksBetween = bookService.getBooksByPublishedYearBetween(startYear.get(), endYear.get());
			books.addAll(booksBetween);
		}
		else {
			if (startYear.isPresent()) {
				List<Book> booksAfter = bookService.getBooksByPublishedYearAfter(startYear.get());
				books.addAll(booksAfter);
			}
			else if (endYear.isPresent()) {
				List<Book> booksBefore = bookService.getBooksByPublishedYearBefore(endYear.get());
				books.addAll(booksBefore);
			}
			else {
				return ResponseEntity.badRequest().body(new MessageResponse("Invalid request parameters. Refer to the API documentation and try again!"));
			}
		}
		
		if (books.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new MessageResponse("No books found for the specified year range"));
		}
		else {
			return ResponseEntity.ok(books);
		}
	}
	
	@DeleteMapping("/delete/title/{title}")
	public ResponseEntity<MessageResponse> deleteBookByBookTitle(@PathVariable("title") String bookTitle) {
		Optional<Book> book = bookService.getBookByBookTitle(bookTitle);
		if(book.isPresent()) {
			bookService.deleteBookByBookTitle(bookTitle);
			return ResponseEntity.ok(new MessageResponse("Book: %s has been successfully deleted from the database".formatted(bookTitle)));
		}
		else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new MessageResponse("Book: %s does not exist!".formatted(bookTitle)));
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<MessageResponse> deleteBookByBookId(@PathVariable("id") Integer bookId) {
		Optional<Book> book = bookService.getBookByBookId(bookId);
		if(book.isPresent()) {
			bookService.deleteBookByBookId(bookId);
			return ResponseEntity.ok(new MessageResponse("Book ID: %d has been successfully deleted from the database".formatted(bookId)));
		}
		else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new MessageResponse("Book ID: %d does not exist!".formatted(bookId)));
		}
	}
}
