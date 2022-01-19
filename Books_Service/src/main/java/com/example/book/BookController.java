package com.example.book;

import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
	
private final BookRepository bookRepository;
	
	BookController(BookRepository repository) {
		bookRepository = repository;
	}

	@GetMapping("/books")
	Iterable<Book> getBooks() {
		return bookRepository.findAll();
	}
	
	@GetMapping("/books/{bookId}")
	Book getBook(@PathVariable Long bookId) {
		return bookRepository.findById(bookId).orElseThrow();
	}
	
	@PostMapping("/books")
	Book createBook(@RequestBody Book newBook ) {
		return bookRepository.save(newBook);
	}
	
	@PutMapping("/books/{bookId}")
	Book updateBook(@PathVariable Long bookId, @RequestBody Book bookDto) {
		Book bookToUpdate = bookRepository.findById(bookId).orElseThrow();
		bookToUpdate.setTitle(bookDto.getTitle());
		bookToUpdate.setAuthor(bookDto.getAuthor());
		return bookRepository.save(bookToUpdate);
	}
	
	@DeleteMapping("/books/{bookId}")
	void deleteBook(@PathVariable Long bookId) {
		Book book = bookRepository.findById(bookId).orElseThrow();
		bookRepository.delete(book);
		
	}
}
