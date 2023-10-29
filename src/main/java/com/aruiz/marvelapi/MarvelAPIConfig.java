package com.aruiz.marvelapi;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan(basePackages = {"com.aruiz.marvelapi.client", "com.aruiz.marvelapi.service"})
public class MarvelAPIConfig {

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplateBuilder().additionalMessageConverters(jacksonConverter()).build();
    }

    private MappingJackson2HttpMessageConverter jacksonConverter() {
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        return converter;
    }

}