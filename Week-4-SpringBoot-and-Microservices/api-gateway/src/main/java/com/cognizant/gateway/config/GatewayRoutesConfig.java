package com.cognizant.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayRoutesConfig {

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("account-service-route", route -> route
                        .path("/accounts/**")
                        .uri("lb://ACCOUNT-SERVICE"))
                .route("loan-service-route", route -> route
                        .path("/loans/**")
                        .uri("lb://LOAN-SERVICE"))
                .build();
    }
}
