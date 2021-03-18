package codes.showme.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import codes.showme.demo.repository.IBookRepository;
import codes.showme.demo.service.IBookService;
import codes.showme.demo.vo.Book;

@Service
public class BookServiceImpl implements IBookService {
	
	@Autowired
	private IBookRepository bookRepository;

	@Override
	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}

	@Override
	public Book getBookById(Integer id) {
		Optional<Book> oBook = bookRepository.findById(id);
		if(oBook.isPresent()) {
			return oBook.get();
		} else {
			return null;
		}
	}

	@Override
	public void delBookById(Integer id) {
		bookRepository.deleteById(id);
	}

	@Override
	public Book saveBook(Book book) {
		return bookRepository.save(book);
	}

	@Override
	public Book findBook(String name) {
		return bookRepository.findBook(name);
	}

	@Override
	public Book findByName(String name) {
		return bookRepository.findByName(name);
	}

	
}
