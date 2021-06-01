package com.chainsys.book.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.chainsys.book.exception.BookNotFoundException;
import com.chainsys.book.model.Book;

public class BookDAOImpl implements BookDAO {
	private static Connection con;
	private static PreparedStatement pstmt;
	private static ResultSet rs;
	private static Set<Book> bookSet;
	private static ArrayList<Integer> idlist;
	private static ArrayList<String> namelist;

	public BookDAOImpl() {
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@fserver.chainsys.com:1521:DBEBS12", "apps", "apps");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public Set<Book> findAll() {
		try {
			pstmt = con.prepareStatement("select * from book_2604");
			rs = pstmt.executeQuery();
			bookSet = new HashSet<>();
			while (rs.next()) {
				Book book = new Book(rs.getInt("book_id"), rs.getString("book_title"),
						rs.getDate("publish_date").toLocalDate());
				bookSet.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bookSet;
	}
	@Override
	public List<Integer> findAllId() {
		try {
			pstmt = con.prepareStatement("select book_id from book_2604");
			rs = pstmt.executeQuery();
			idlist = new ArrayList<>();
			while (rs.next()) {
				idlist.add(rs.getInt("book_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return idlist;
	}
	@Override
	public List<String> findAllName() {
		try {
			pstmt = con.prepareStatement("select book_title from book_2604");
			rs = pstmt.executeQuery();
			namelist = new ArrayList<>();
			while (rs.next()) {
				namelist.add(rs.getString("book_title"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return namelist;	
	}
	@Override
	public Book findById(int id) throws BookNotFoundException {
		Book book = null;
		try {
			pstmt = con.prepareStatement("select * from book_2604 where book_id=?");
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				book = new Book(rs.getInt("book_id"), rs.getString("book_title"), rs.getDate("publish_date").toLocalDate());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return book;
	}
	@Override
	public Book findByName(String name) throws BookNotFoundException {
		Book book = null;
		try {
			pstmt = con.prepareStatement("select * from book_2604 where book_title=?");
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				book = new Book(rs.getInt("book_id"), rs.getString("book_title"), rs.getDate("publish_date").toLocalDate());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return book;
	}
	
	@Override
	public Book findByDate(LocalDate date) throws BookNotFoundException {
		Book book = null;
		try {
			pstmt = con.prepareStatement("select * from book_2604 where publish_date=?");
			pstmt.setDate(1, Date.valueOf(date));
			rs = pstmt.executeQuery();
			if (rs.next()) {
				book = new Book(rs.getInt("book_id"), rs.getString("book_title"), rs.getDate("publish_date").toLocalDate());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return book;
	}

}
