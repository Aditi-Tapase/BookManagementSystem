package com.example.BookManagementSystem.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BookManagementSystem.dao.BookDao;
import com.example.BookManagementSystem.entity.Book;
@Service
public class BookService {
	
	@Autowired
	BookDao bookDao;
	
	//BookDao bookDao=new BookDao();
	public Book getBookbyId(int id) {
		return bookDao.getBookbyId(id);
	}
	public String addbook(Book book) {
		int i = bookDao.addbook(book);
		if(i>0) {
			return i+ "book added";
		}else {
			return "book not added";
		}
	}
	
	public void deleteBook(int id) {
		bookDao.deleteBook(id);
	}
	
	public ArrayList<Book> getListOfBooks(){
		return bookDao.getListofBooks();
	}

}
