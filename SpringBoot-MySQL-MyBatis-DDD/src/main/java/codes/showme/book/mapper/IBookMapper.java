package codes.showme.book.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import codes.showme.book.vo.Book;

public interface IBookMapper {
	Long save(Book book);
	
	List<Book> findAll();
	
	Book findById(@Param("id") Integer id);
	
	Book findByName(@Param("name") String name);
	
	void deleteById(@Param("id") Integer id);

	int updateBook(Book book);
}
