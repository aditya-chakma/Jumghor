package com.iAxis.jumghor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan("com.iAxis.jumghor.entities.entity")
@EnableJpaRepositories
@SpringBootApplication
@EnableCaching // todo: disable this annotation
public class JumghorApplication {

    public static void main(String[] args) {
        SpringApplication.run(JumghorApplication.class, args);
    }

}
