package com.iAxis.jumghor.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {
        "com.iAxis.jumghor.user",
        "com.iAxis.jumghor.entities.configs",
        "com.iAxis.jumghor.entities.utils"
})
@EntityScan("com.iAxis.jumghor.entities.entity")
@EnableCaching // todo: disable this annotation
@SpringBootApplication
public class UserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }

}
