package com.cognizant.ormlearn;

import com.cognizant.ormlearn.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrmLearnApplication implements CommandLineRunner {

    @Autowired
    private EmployeeRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(OrmLearnApplication.class, args);
    }

    @Override
    public void run(String... args) {

        System.out.println("=== HQL ===");
        repository.getAllPermanentEmployees()
                .forEach(e -> System.out.println(e.getName()));

        System.out.println("=== Native Query ===");
        repository.getAllEmployeesNative()
                .forEach(e -> System.out.println(e.getName()));
    }
}