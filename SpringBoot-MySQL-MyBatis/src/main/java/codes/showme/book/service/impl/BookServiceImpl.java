package codes.showme.book.service.impl;

import java.util.List;
import java.util.Optional;

import codes.showme.book.service.CacheService;
import codes.showme.book.service.CountService;
import codes.showme.book.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import codes.showme.book.mapper.IBookMapper;
import codes.showme.book.service.IBookService;
import codes.showme.book.vo.Book;

@Service
public class BookServiceImpl implements IBookService {
	
	@Autowired
	private IBookMapper bookMapper;

	@Autowired
	private CountService countService;

	@Autowired
	private ReviewService reviewService;

	@Autowired
	private CacheService cacheService;

	@Override
	public List<Book> getAllBooks() {
		return bookMapper.findAll();
	}

	@Override
	public Book getBookById(Integer id) {
		Optional<String> jsonString  = cacheService.getString(getBookCacheKeyString(id));
		if (jsonString.isPresent()) {
			return BookBuilder.fromJson(jsonString.get());
		}else {
			return bookMapper.findById(id);
		}
	}

	private String getBookCacheKeyString(Integer id) {
		return null;
	}

	@Override
	public void delBookById(Integer id) {
		bookMapper.deleteById(id);
	}

	@Override
	public Long saveBook(Book book) {
		// 实现计算字数
		// 注意book的字数本身不应该由外部设置的。count更应该是在Book构建时设置的。
		long count = countService.count(book.getText());
		book.setCount(count);

		Long id = bookMapper.save(book);

		// 实现审查
		reviewService.review(id);

		return id;
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
