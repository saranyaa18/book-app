package com.chainsys.book.test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.chainsys.book.exception.BookNotFoundException;
import com.chainsys.book.model.Book;
import com.chainsys.book.service.BookService;
import com.chainsys.book.service.BookServiceImpl;

public class BookClient {
	public static void main(String[] args) {

		Set<Book> bookSet;
		List<Integer> idlist;
		List<String> namelist;
		String date;
		DateTimeFormatter dateFormat;
		BookService service = new BookServiceImpl();
		System.out.println(" 1. Find All Books");
		System.out.println(" 2. Find All Books Id");
		System.out.println(" 3. Find All Books name");
		System.out.println(" 4. Find the book by id");
		System.out.println(" 5. Find the book by name");
		System.out.println(" 6. Find the book by publish date");
		
		
		System.out.println("Enter the choice");
		Scanner scanner = new Scanner(System.in);
		int choice = scanner.nextInt();
		switch (choice) {
		case 1:
			System.out.println("Find All Books");
			bookSet = service.findAll();
			System.out.println(bookSet);
			break;
			
		case 2:
			System.out.println("Find All Books Id");
			idlist = service.findAllId();
			System.out.println(idlist);
			break;
		case 3:
			System.out.println("Find All Books name");
			namelist=service.findAllName();
			System.out.println(namelist);
			break;
		case 4:
			System.out.println("Find the book by id");
			Scanner sc=new Scanner(System.in);
			Integer id=sc.nextInt();
			try {
			Book book = service.findById(id);
			System.out.println(book);
			}
			catch(BookNotFoundException e){		
			}
			break;
		case 5:
			System.out.println("Find the book by name");
			sc=new Scanner(System.in);
			String name=sc.next();
			try {
			Book book = service.findByName(name);
			System.out.println(book);
			}
			catch(BookNotFoundException e){		
			}
			break;
		case 6:
			System.out.println("Find the book by publish date");
			try {
				date="06/24/2015";
				dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
				Book book=service.findByDate(LocalDate.parse(date,dateFormat));
				System.out.println(book);
			}
			catch(BookNotFoundException e){		
			}
			break;
			
		default:
			break;
		}
		scanner.close();
	}

}
