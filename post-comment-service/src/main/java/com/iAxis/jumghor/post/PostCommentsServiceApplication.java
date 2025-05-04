package com.iAxis.jumghor.post;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan("com.iAxis.jumghor.entities.entity")
@EnableJpaRepositories
@SpringBootApplication
public class PostCommentsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PostCommentsServiceApplication.class, args);
	}

}
