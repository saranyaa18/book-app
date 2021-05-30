package com.chainsys.book.test;

import java.util.Scanner;
import java.util.Set;
//import java.time.format.DateTimeFormatter;
//import java.util.List;
import com.chainsys.book.model.Book;
import com.chainsys.book.service.BookService;
import com.chainsys.book.service.BookServiceImpl;

public class BookClient {
	public static void main(String[] args) {

		Set<Book> bookSet;
		BookService service = new BookServiceImpl();
		System.out.println(" 1. Find All Books");
		System.out.println("Enter the choice");
		Scanner scanner = new Scanner(System.in);
		int choice = scanner.nextInt();
		switch (choice) {
		case 1:
			System.out.println("Find All Books");
			bookSet = service.findAll();
			System.out.println(bookSet);
			break;
		default:
			break;
		}
		scanner.close();
	}

}
