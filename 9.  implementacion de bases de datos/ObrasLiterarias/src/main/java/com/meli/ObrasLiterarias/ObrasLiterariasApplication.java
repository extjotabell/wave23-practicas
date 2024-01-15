package com.meli.ObrasLiterarias;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.meli.ObrasLiterarias.repository.jpa")
@EnableElasticsearchRepositories(basePackages = "com.meli.ObrasLiterarias.repository.elasticsearch")
public class ObrasLiterariasApplication {

	public static void main(String[] args) {
		SpringApplication.run(ObrasLiterariasApplication.class, args);
	}

}
