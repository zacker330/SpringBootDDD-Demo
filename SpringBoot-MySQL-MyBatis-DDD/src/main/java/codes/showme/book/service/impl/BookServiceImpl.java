package codes.showme.book.service.impl;

import java.util.List;

import codes.showme.book.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import codes.showme.book.mapper.IBookMapper;
import codes.showme.book.vo.Book;

@Service
public class BookServiceImpl implements IBookService {
	
	@Autowired
	private IBookMapper bookMapper;

	@Override
	public List<Book> getAllBooks() {
		return bookMapper.findAll();
	}

	@Override
	public Book getBookById(Integer id) {
		Book book = bookMapper.findById(id);
		return book;
	}

	@Override
	public void delBookById(Integer id) {
		bookMapper.deleteById(id);
	}

	@Override
	public Long saveBook(Book book) {
		return bookMapper.save(book);
	}

	@Override
	public Book findByName(String name) {
		return bookMapper.findByName(name);
	}

	@Override
	public int updateBook(Book book) {
		return bookMapper.updateBook(book);
	}
}
