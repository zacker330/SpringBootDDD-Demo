package codes.showme.book.demo.mapper;

import codes.showme.book.domain.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookMapper {
	Long save(Book book);
	
	List<Book> findAll();
	
	Book findById(@Param("id") Integer id);
	
	Book findByName(@Param("name") String name);
	
	void deleteById(@Param("id") Integer id);

	int updateBook(Book book);
}
