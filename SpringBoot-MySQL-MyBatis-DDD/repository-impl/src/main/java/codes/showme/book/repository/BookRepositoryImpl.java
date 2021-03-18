package codes.showme.book.repository;

import codes.showme.book.demo.mapper.BookMapper;
import codes.showme.book.domain.Book;
import codes.showme.book.domain.BookBuilder;
import codes.showme.book.service.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class BookRepositoryImpl implements BookRepository {

    @Autowired
    private BookMapper mapper;

    @Autowired
    private CacheService cacheService;


    @Override
    public Long save(Book book) {
        return mapper.save(book);
    }

    @Override
    public List<Book> findAll() {
        return mapper.findAll();
    }

    @Override
    public Book findById(Integer id) {
        Optional<String> jsonString  = cacheService.getString(getBookCacheKeyString(id));
        if (jsonString.isPresent()) {
            return BookBuilder.fromJson(jsonString.get());
        }else {
            return mapper.findById(id);
        }
    }

    private String getBookCacheKeyString(Integer id) {
        return "BOOK_" + id;
    }

    @Override
    public Book findByName(String name) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public int update(Book book) {
        return 0;
    }

    @Override
    public int remove(Book book) {
        return 0;
    }

    @Override
    public void update(Integer id, String name, Integer price) {

    }
}
