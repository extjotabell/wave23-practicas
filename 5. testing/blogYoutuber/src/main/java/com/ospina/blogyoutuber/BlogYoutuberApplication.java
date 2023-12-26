package com.ospina.blogyoutuber;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.validation.annotation.Validated;

@SpringBootApplication
@Validated
public class BlogYoutuberApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogYoutuberApplication.class, args);
	}

}
