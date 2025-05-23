package com.iAxis.jumghor.api_gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author aditya.chakma
 * @since 18 May, 2025
 */
@Configuration
public class ApiGatewayConfiguration {

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
        // todo: replace with routing configuration file
        return builder.routes()
                .route(p -> p.path("/pc/**")
                        .filters(f -> f.rewritePath("/pc/(?<segment>.*)","/${segment}"))
                        .uri("lb://post-comment-service"))

                .route(p -> p.path("/u/**")
                        .filters(f -> f.rewritePath("/u/(?<segment>.*)", "/${segment}"))
                        .uri("lb://user-service"))

                .route(p -> p.path("/r/**")
                        .filters(f -> f.rewritePath("/r/(?<segment>.*)", "/${segment}"))
                        .uri("lb://relation-service"))

                .build();
    }

}
