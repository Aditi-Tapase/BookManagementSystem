package com.example.BookManagementSystem.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.BookManagementSystem.entity.Book;
import com.example.BookManagementSystem.service.BookService;

@RestController
public class BookController {
	
	@Autowired
	BookService bookService;
	//BookService bookService=new BookService();
	
	@GetMapping("getbookbyid/{id}")
	Book getBookbyId(@PathVariable  int id) {
		
		return bookService.getBookbyId(id);
		
	}
	
	@PostMapping("addbook")
	void addbook(@RequestBody Book book)
	{
		bookService.addbook(book);
		
		
	}
	
	@DeleteMapping("deletebook/{id}")
	public void deletebook(@PathVariable int id)
	{
		bookService.deleteBook(id);
		
	}
	
	@GetMapping("getListOfBooks")
	public ArrayList<Book> getListOfBooks()
	{
		return bookService.getListOfBooks();
	}
	

}
