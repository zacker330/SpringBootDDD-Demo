package com.priesttomb.demo.vo;

public class Book {
	
	private Integer id;

	private String name;
	
	private Integer price;
	
	public Book() {
		
	}
	
	public Book(String name, Integer price) {
		this.name = name;
		this.price = price;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}
	
	
}
