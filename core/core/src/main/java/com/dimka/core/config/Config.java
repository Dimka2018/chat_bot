package com.dimka.core.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@EnableWebFlux
public class Config implements WebFluxConfigurer {

    @LoadBalanced
    @Scope("prototype")
    @Bean
    WebClient.Builder webClientBuilder() {
        return WebClient.builder();
    }
}
