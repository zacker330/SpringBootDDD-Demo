package com.priesttomb.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.priesttomb.demo.mapper")
public class SpringBootMySqlMyBatisApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMySqlMyBatisApplication.class, args);
	}
}
