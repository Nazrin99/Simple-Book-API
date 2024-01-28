package com.example.bookapi.repository;

import com.example.bookapi.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
	@Query("SELECT book FROM Book book WHERE book.bookTitle = ?1")
	Book getBookByBookTitle(String bookTitle);
	
	@Query("SELECT book FROM Book book WHERE book.genre = ?1")
	List<Book> getBooksByGenre(String genre);
	
	@Query("SELECT book FROM Book book WHERE book.publishedYear > ?1 and book.publishedYear < ?2")
	List<Book> getBooksByPublishedYearBetween(Integer startYear, Integer endYear);
	
	@Query("SELECT book FROM Book book WHERE book.publishedYear > ?1")
	List<Book> getBooksByPublishedYearAfter(Integer publishedYear);
	
	@Query("SELECT book FROM Book book WHERE book.publishedYear < ?1")
	List<Book> getBooksByPublishedYearBefore(Integer publishedYear);
	
	@Query("SELECT book FROM Book book WHERE book.authorName = ?1")
	List<Book> getBooksByAuthorName(String authorName);
	
	@Modifying
	@Query("DELETE FROM Book book WHERE book.bookTitle = ?1")
	void deleteBookByBookTitle(String bookTitle);
	
}
