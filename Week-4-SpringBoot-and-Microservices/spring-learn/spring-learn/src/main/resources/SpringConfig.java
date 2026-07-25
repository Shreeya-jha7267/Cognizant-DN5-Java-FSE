package com.cognizant.springlearn.config;

import com.cognizant.springlearn.bean.Country;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public Country country() {
        Country country = new Country();
        country.setCode("IN");
        country.setName("India");
        return country;
    }
}