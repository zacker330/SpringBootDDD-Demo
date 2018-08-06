package com.priesttomb.demo.service;

import java.util.List;

import com.priesttomb.demo.vo.Book;

public interface IBookService {
	public List<Book> getAllBooks();
	
	public Book getBookById(Integer id);
	
	public void delBookById(Integer id);
	
	public Book saveBook(Book book);
	
	public Book findBook(String name);
	
	public Book findByName(String name);
}
