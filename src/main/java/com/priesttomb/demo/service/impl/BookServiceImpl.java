package com.priesttomb.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.priesttomb.demo.dao.IBookDao;
import com.priesttomb.demo.service.IBookService;
import com.priesttomb.demo.vo.Book;

@Service
public class BookServiceImpl implements IBookService {
	
	@Autowired
	private IBookDao bookDao;

	@Override
	public List<Book> getAllBooks() {
		return bookDao.findAll();
	}

	@Override
	public Book getBookById(Integer id) {
		Optional<Book> oBook = bookDao.findById(id);
		if(oBook.isPresent()) {
			return oBook.get();
		} else {
			return null;
		}
	}

	@Override
	public void delBookById(Integer id) {
		bookDao.deleteById(id);
	}

	@Override
	public Book saveBook(Book book) {
		return bookDao.save(book);
	}

	@Override
	public Book findBook(String name) {
		return bookDao.findBook(name);
	}

	@Override
	public Book findByName(String name) {
		return bookDao.findByName(name);
	}

	
}
