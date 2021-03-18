package codes.showme.book.repository;

import codes.showme.book.domain.Book;

import java.util.List;

public interface BookRepository {
    Long save(Book book);

    List<Book> findAll();

    Book findById(Integer id);

    Book findByName(String name);

    void deleteById(Integer id);

    int update(Book book);

    int remove(Book book);

    void update(Integer id, String name, Integer price);
}
