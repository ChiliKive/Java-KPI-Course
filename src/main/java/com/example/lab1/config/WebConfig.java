package com.example.lab1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestFactorySettings;
import org.springframework.http.client.ClientHttpRequestFactories;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.time.Duration;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/api-specs/**")
                .addResourceLocations("/resources/api-specs/");
    }

    @Bean
    public ClientHttpRequestFactory clientHttpRequestFactory() {
        return createClientHttpRequestFactory(5000);
    }

    private ClientHttpRequestFactory createClientHttpRequestFactory(int responseTimeout) {
        ClientHttpRequestFactorySettings settings = ClientHttpRequestFactorySettings.DEFAULTS
                .withReadTimeout(Duration.ofMillis(responseTimeout));
        return ClientHttpRequestFactories.get(settings);
    }
}
