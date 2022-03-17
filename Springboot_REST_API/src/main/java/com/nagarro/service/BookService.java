package com.nagarro.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.dao.BookRepository;
import com.nagarro.model.Book;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	//finding all the books
	public List<Book> getAllBooks(){
		List<Book> books=(List<Book>) this.bookRepository.findAll();
		return books;
	}
	
	//finding book by id
	public Optional<Book> findBookById(String bookId){
		Optional<Book> book=null;
		try {
			book=this.bookRepository.findById(bookId);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return book;
	}
	//adding a book
	public Book addBook(Book book) {
		Book result= this.bookRepository.save(book);
		return result;
	}
	
	//delete a book
	public void deleteBook(String bookId) {
		this.bookRepository.deleteById(bookId);
	}
	
	//update a book
	public void updateBook(Book book,String bookId) {
		book.setBookId(bookId);
		this.bookRepository.save(book);
	}
}
