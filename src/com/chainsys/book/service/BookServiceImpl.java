package com.chainsys.book.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import com.chainsys.book.dao.BookDAO;
import com.chainsys.book.dao.BookDAOImpl;
import com.chainsys.book.exception.BookNotFoundException;
import com.chainsys.book.model.Book;

public class BookServiceImpl implements BookService{

	private static BookDAO dao;
	
	public BookServiceImpl() {
		dao=new BookDAOImpl();
	}
	
	@Override
	public Set<Book> findAll() {
		return dao.findAll();
	}

	@Override
	public List<Integer> findAllId() {
		return dao.findAllId();

	}

	@Override
	public List<String> findAllName() {
		return dao.findAllName();

	}

	@Override
	public Book findById(int id) throws BookNotFoundException {
		Book book=dao.findById(id);
		if (book == null) {
			throw new BookNotFoundException("Book Id Not Found");
		} else {
			return book;
		}
	}

	@Override
	public Book findByName(String name) throws BookNotFoundException {
		Book book=dao.findByName(name);
		if (book == null) {
			throw new BookNotFoundException("Book Name Not Found");
		} else {
			return book;
		}
	}

	@Override
	public Book findByDate(LocalDate date) throws BookNotFoundException {
		Book book=dao.findByDate(date);
		if (book == null) {
			throw new BookNotFoundException("Publish date Not Found");
		} else {
			return book;
		}
	}
	
}
