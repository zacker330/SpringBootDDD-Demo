package codes.showme.demo.service;

import java.util.List;

import codes.showme.demo.vo.Book;

public interface IBookService {
	public List<Book> getAllBooks();
	
	public Book getBookById(Integer id);
	
	public void delBookById(Integer id);
	
	public Long saveBook(Book book);
	
	public Book findByName(String name);
	
	public int updateBook(Book book);
}
