package com.cognizant.springlearn;

import com.cognizant.springlearn.bean.Country;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringLearnApplication implements CommandLineRunner {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(SpringLearnApplication.class);

    @Autowired
    private Country country;

    public static void main(String[] args) {
        SpringApplication.run(SpringLearnApplication.class, args);
    }

    @Override
    public void run(String... args) {
        LOGGER.info("Country : {}", country);
    }
}