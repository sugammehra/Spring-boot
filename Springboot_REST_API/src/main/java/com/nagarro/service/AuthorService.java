package com.nagarro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.dao.AuthorRepository;
import com.nagarro.model.Author;

@Service
public class AuthorService {
	@Autowired
	private AuthorRepository authorRepository;
	
	//finding all authors
	public List<Author> getAllAuthors(){
		List<Author> list=(List<Author>) this.authorRepository.findAll();
		return list;
	}
	
	//adding new author
	public Author addAuthor(Author author) {
		Author result=this.authorRepository.save(author);
		return result;
	}
	
	//deleting the author
	public void deleteAuthor(int id) {
		this.authorRepository.deleteById(id);
	}
	
	//updating the author
	public void updateAuthor(Author author,int id) {
		author.setAuthorId(id);
		this.authorRepository.save(author);
	}
}
