package com.priesttomb.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.priesttomb.demo.vo.Book;

@Repository
public interface IBookDao extends JpaRepository<Book, Integer>{
	
	//JPA对方法名解析，可以自动生成HQL查询
	Book findByName(String name);
	
	@Query("from Book b where b.name=:name")
	Book findBook(String name);
}
