package codes.showme.book.service;

import java.util.List;

import codes.showme.book.vo.Book;

public interface IBookService {
	public List<Book> getAllBooks();
	
	public Book getBookById(Integer id);
	
	public void delBookById(Integer id);
	
	public Long saveBook(Book book);
	
	public Book findByName(String name);
	
	public int updateBook(Book book);
}
