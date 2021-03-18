package codes.showme.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("codes.showme.demo.mapper")
public class SpringBootMySqlMyBatisApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMySqlMyBatisApplication.class, args);
	}
}
