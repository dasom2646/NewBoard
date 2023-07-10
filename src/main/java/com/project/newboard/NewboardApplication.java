package com.project.newboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import javax.sql.DataSource;
import java.sql.Connection;

@SpringBootApplication
public class NewboardApplication implements CommandLineRunner {
@Autowired
private DataSource dataSource;
	public static void main(String[] args) {
		SpringApplication.run(NewboardApplication.class, args);
	}
	@Override
	public void run(String... args) {
		try (Connection connection = dataSource.getConnection()) {
			ClassPathResource scriptResource = new ClassPathResource("schema.sql");
			ScriptUtils.executeSqlScript(connection, scriptResource);
		} catch (Exception e) {
			// 예외 처리 코드를 작성합니다.
			e.printStackTrace();
		}
	}
}