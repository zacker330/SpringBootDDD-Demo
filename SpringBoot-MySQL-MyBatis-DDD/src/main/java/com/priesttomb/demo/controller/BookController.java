package com.priesttomb.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.priesttomb.demo.service.IBookService;
import com.priesttomb.demo.vo.Book;

@RestController
public class BookController {
	
	@Autowired
	private IBookService bookService;
	
	/**
	 * 添加一本书（用form-data传来的各个字段）
	 * @param name
	 * @param price
	 */
//	@PostMapping(value = "/book")
//	public void addBook(@RequestParam(value="name") String name,@RequestParam(value="price") Integer price) {
//		Book book = new Book(name, price);
//		bookService.saveBook(book);
//	}
	/**
	 * 添加一本书（使用json格式直接传递一个对象）
	 */
	@PostMapping(value = "/book", consumes = "application/json")
	public void addBook(@RequestBody Book book) {
		bookService.saveBook(book);
	}
	
	/**
	 * 获取所有的书
	 * @return
	 */
	@GetMapping(value = "/book")
	public List<Book> getAllBooks() {
		return bookService.getAllBooks();
	}
	
	/**
	 * 根据书的id获取书
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/book/{id}")
	public Book getBookById(@PathVariable("id") Integer id) {
		return bookService.getBookById(id);
	}
	
	/**
	 * 根据书的id删除书
	 * @param id
	 */
	@DeleteMapping(value = "/book/{id}")
	public void delBookById(@PathVariable("id") Integer id) {
		bookService.delBookById(id);
	}
	
	/**
	 * 根据书名查书
	 * @param name
	 * @return
	 */
	@GetMapping(value = "/book/name/{name}")
	public Book findByName(@PathVariable("name") String name) {
		return bookService.findByName(name);
	}
	
	/**
	 * 更新一本书（使用json格式直接传递一个对象）
	 * @param book
	 * @param id
	 * @return
	 */
	@PutMapping(value = "/book/{id}", consumes = "application/json")
	public String updateById(@RequestBody Book book, @PathVariable("id") Integer id) {
		int result = bookService.updateBook(book);
		return result == 1 ? "succ" : "fail";
	}
}
