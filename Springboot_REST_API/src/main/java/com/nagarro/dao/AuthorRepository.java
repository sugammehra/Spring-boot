package com.nagarro.dao;

import org.springframework.data.repository.CrudRepository;

import com.nagarro.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Integer> {

}
