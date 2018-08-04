package com.priesttomb.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.priesttomb.demo.vo.Book;

@Repository
public interface IBookDao extends JpaRepository<Book, Integer>{
	
}
