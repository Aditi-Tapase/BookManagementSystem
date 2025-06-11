package com.example.BookManagementSystem.entity;


public class Book {
	int  id;
	String Name;
	String Author;
	Double price;
	public Book(int id, String name, String author, Double price) {
		super();
		this.id = id;
		Name = name;
		Author = author;
		this.price = price;
	}
	
	public Book(String name, String author, Double price) {
		super();
		Name = name;
		Author = author;
		this.price = price;
	}
	
	public Book() {}
	

	public Book(int id) {
		super();
		this.id = id;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getAuthor() {
		return Author;
	}
	public void setAuthor(String author) {
		Author = author;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", Name=" + Name + ", Author=" + Author + ", price=" + price + "]";
	}
	

}
