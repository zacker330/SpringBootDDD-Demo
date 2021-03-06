package codes.showme.book.repository;

import codes.showme.book.vo.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookRepository extends JpaRepository<Book, Integer>{
	
	//JPA对方法名解析，可以自动生成HQL查询
	Book findByName(String name);
	
	@Query("from Book b where b.name=:name")
	Book findBook(@Param("name") String name);
}