package com.chainsys.book.service;

import java.util.Set;

import com.chainsys.book.model.Book;

public interface BookService {
	
	Set<Book> findAll();
}
