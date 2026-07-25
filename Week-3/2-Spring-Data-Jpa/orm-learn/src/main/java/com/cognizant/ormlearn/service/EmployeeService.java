package com.cognizant.ormlearn.service;

import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    public List<Employee> getAllPermanentEmployees() {
        return repository.getAllPermanentEmployees();
    }

    public double getAverageSalary(int id) {
        return repository.getAverageSalary(id);
    }

    public Employee save(Employee employee) {
        return repository.save(employee);
    }
}