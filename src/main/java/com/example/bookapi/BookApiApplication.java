package com.example.bookapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
public class BookApiApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(BookApiApplication.class, args);
	}
	
}
