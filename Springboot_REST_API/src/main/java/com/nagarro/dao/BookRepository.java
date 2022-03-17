package com.nagarro.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.nagarro.model.Book;

public interface BookRepository extends CrudRepository<Book, String>{
	public Optional<Book> findById(String id);

}
