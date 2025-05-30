package com.iAxis.jumghor.post;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan({
        "com.iAxis.jumghor.post",
        "com.iAxis.jumghor.entities.configs" // enabling jpa auditing
})
@EntityScan(basePackages = {
        "com.iAxis.jumghor.post",
        "com.iAxis.jumghor.entities.entity"
})
@SpringBootApplication
@EnableFeignClients
public class PostCommentsServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PostCommentsServiceApplication.class, args);
    }

}
