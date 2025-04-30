package com.iAxis.jumghor.relation_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({
        "com.iAxis.jumghor.relation_service",
        "com.iAxis.jumghor.entities.configs",
        "com.iAxis.jumghor.entities.interceptor"
})
@EntityScan("com.iAxis.jumghor.entities.entity")
@EnableFeignClients
@SpringBootApplication
public class RelationServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RelationServiceApplication.class, args);
    }

}
