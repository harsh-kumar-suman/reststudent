package com.api.student.reststudent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories()
public class ReststudentApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReststudentApplication.class, args);
	}

}
