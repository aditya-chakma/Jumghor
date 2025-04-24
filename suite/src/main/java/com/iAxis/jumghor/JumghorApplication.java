package com.iAxis.jumghor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan("com.iAxis.jumghor.entities.entity")
@EnableJpaRepositories
@SpringBootApplication
public class JumghorApplication {

    public static void main(String[] args) {
        SpringApplication.run(JumghorApplication.class, args);
    }

}
