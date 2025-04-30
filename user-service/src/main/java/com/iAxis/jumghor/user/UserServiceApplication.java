package com.iAxis.jumghor.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = {
        "com.iAxis.jumghor.user",
        "com.iAxis.jumghor.entities.configs",
        "com.iAxis.jumghor.entities.interceptor"
})
@EntityScan("com.iAxis.jumghor.entities.entity")
@EnableJpaRepositories
@EnableCaching // todo: disable this annotation
@SpringBootApplication
public class UserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }

}
