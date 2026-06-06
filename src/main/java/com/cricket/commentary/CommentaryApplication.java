package com.cricket.commentary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CommentaryApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommentaryApplication.class, args);
	}

}
