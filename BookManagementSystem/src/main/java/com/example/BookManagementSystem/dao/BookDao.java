package com.example.BookManagementSystem.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.example.BookManagementSystem.entity.Book;

@Repository
public class BookDao {
	private static final String url="jdbc:mysql://localhost:3306/bms";
	private static final String username="root";
	private static final String password="aditi@2003";
	
	private PreparedStatement pstmt=null;
	public static Connection getDbConnection() {
		Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url, username, password);
			System.out.println("Connection Established");
		} catch(Exception e) {
			e.printStackTrace();
		}
		return con;
		
	}
	
	public Book getBookbyId(int id) {
		String sql="select * from book where id=?";
		Book b = null;
		try {
			pstmt=getDbConnection().prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				int i=rs.getInt(1);
				String name=rs.getString(2);
				String author=rs.getString(3);
				double price=rs.getDouble(4);
				b=new Book(id, name, author, price);
				
			}
			
		} catch (SQLException e) {
			System.out.println("Id is Invalid");
			
		}
		return b;
		
	}
	
     public int addbook(Book book) {
    	 int rowcount=0;
	String sql="insert into book value(?,?,?,?)";	
	try {
		pstmt=getDbConnection().prepareStatement(sql);
		pstmt.setInt(1, book.getId());
		pstmt.setString(2,  book.getName());
		pstmt.setString(3,  book.getAuthor());
		pstmt.setDouble(4,  book.getPrice());
		rowcount=pstmt.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}  return rowcount; 
     
     }
     
     public int deleteBook(int id) {
    	 int rowcount=0;
	String sql="delete from book where id=?";	
	try {
		pstmt=getDbConnection().prepareStatement(sql);
		pstmt.setInt(1, id);
		
		rowcount=pstmt.executeUpdate();
		System.out.println("book deleted successfully");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}  return rowcount; 
     
     }
     public ArrayList<Book> getListofBooks() {
    	 
	String sql="SELECT * FROM book";
	ArrayList<Book> albook=new ArrayList<>();
	try {
		pstmt=getDbConnection().prepareStatement(sql);
		ResultSet rs=pstmt.executeQuery();
		while(rs.next())
		{
			int i=rs.getInt(1);
			String name=rs.getString(2);
			String author=rs.getString(3);
			double price=rs.getDouble(4);
			Book b=new Book(i, name,author,price);
			albook.add(b);
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		System.out.println("ID is Invalid");
	}   return albook;
     

	

     }}
