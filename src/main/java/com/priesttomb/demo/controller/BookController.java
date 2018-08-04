package com.priesttomb.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.priesttomb.demo.service.IBookService;
import com.priesttomb.demo.vo.Book;

@RestController
public class BookController {
	
	@Autowired
	private IBookService bookService;
	
	@PostMapping(value = "/book")
	public Book addBook(@RequestParam(value="name") String name,@RequestParam(value="price") Integer price) {
		Book book = new Book(name, price);
		Book book2 = bookService.saveBook(book);
		return book2;
	}
	
	@GetMapping(value = "/book")
	public List<Book> getAllBooks() {
		return bookService.getAllBooks();
	}
	
	@GetMapping(value = "/book/{id}")
	public Book getBookById(@PathVariable("id") Integer id) {
		return bookService.getBookById(id);
	}
	
	@DeleteMapping(value = "/book/{id}")
	public void delBookById(@PathVariable("id") Integer id) {
		bookService.delBookById(id);
	}
}
