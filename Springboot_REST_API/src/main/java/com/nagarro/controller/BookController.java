package com.nagarro.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.model.Book;
import com.nagarro.service.BookService;

@RestController
public class BookController {
	@Autowired
	private BookService bookService;
	
//	@RequestMapping(value = "/home",method = RequestMethod.GET)
	@GetMapping("/books")
	public ResponseEntity<List<Book>> getBooks() {
		List<Book> list=this.bookService.getAllBooks();
		if(list.size()<=0) {
			//create the response with status 404 not found if list is empty
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list)); 
	}
	
	@GetMapping("/books/{bookId}")
	public ResponseEntity<Optional<Book>> getBookById(@PathVariable("bookId") String bookId) {
		Optional<Book> book=this.bookService.findBookById(bookId);
		if(book==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.ok(book);
	}
	
	@PostMapping("/books")
	public ResponseEntity<Book> addBook(@RequestBody Book b) {
		Book book=null;
		try {
			book=this.bookService.addBook(b);
			return ResponseEntity.status(HttpStatus.CREATED).body(book);
		}
		catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@DeleteMapping("/books/{bookId}")
	public ResponseEntity<Void> deleteBook(@PathVariable("bookId") String bookId) {
		try {
			this.bookService.deleteBook(bookId);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@PutMapping("/books/{bookId}")
	public ResponseEntity<Book> updateBook(@RequestBody Book book,@PathVariable String bookId) {
	     try {
	    	 this.bookService.updateBook(book, bookId);
	    	 return ResponseEntity.of(Optional.of(book));
	     }catch (Exception e) {
			// TODO: handle exception
	    	 e.printStackTrace();
	    	 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}
