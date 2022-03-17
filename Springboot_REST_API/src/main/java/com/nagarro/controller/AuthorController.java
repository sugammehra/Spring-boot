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

import com.nagarro.model.Author;
import com.nagarro.service.AuthorService;

@RestController
public class AuthorController {
	@Autowired
	private AuthorService authorService;
	
	@GetMapping("/authors")
	public ResponseEntity<List<Author>> getAuthors(){
		List<Author> list=this.authorService.getAllAuthors();
		if(list.size()<=0) {
			//create the response with status 404 not found if list is empty
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list)); 
	}
	
	@PostMapping("/authors")
	public ResponseEntity<Author> addAuthor(@RequestBody Author a) {
		Author author=null;
		try {
			author=this.authorService.addAuthor(a);
			return ResponseEntity.status(HttpStatus.CREATED).body(author);
		}
		catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@DeleteMapping("/authors/{authorId}")
	public ResponseEntity<Void> deleteBook(@PathVariable("authorId") int authorId) {
		try {
			this.authorService.deleteAuthor(authorId);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@PutMapping("/authors/{authorId}")
	public ResponseEntity<Author> updateAuthor(@RequestBody Author author,@PathVariable int authorId) {
	     try {
	    	 this.authorService.updateAuthor(author, authorId);
	    	 return ResponseEntity.of(Optional.of(author));
	     }catch (Exception e) {
			// TODO: handle exception
	    	 e.printStackTrace();
	    	 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
}
