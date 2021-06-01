package com.chainsys.book.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import com.chainsys.book.exception.BookNotFoundException;
import com.chainsys.book.model.Book;

public interface BookService {
	
	Set<Book> findAll();
	List<Integer> findAllId();
	List<String> findAllName();
	Book findById(int id) throws BookNotFoundException;
	Book findByName(String name) throws BookNotFoundException;
	Book findByDate(LocalDate date) throws BookNotFoundException;

}
