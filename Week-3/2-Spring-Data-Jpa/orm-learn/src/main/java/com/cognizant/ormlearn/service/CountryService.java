package com.cognizant.ormlearn.service;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    @Autowired
    private CountryRepository repository;

    public List<Country> getAllCountries() {
        return repository.findAll();
    }

    public Country getCountry(String code) {
        return repository.findById(code).orElse(null);
    }

    public Country addCountry(Country country) {
        return repository.save(country);
    }

    public List<Country> findByName(String name) {
        return repository.findByName(name);
    }

    public List<Country> findByKeyword(String keyword) {
        return repository.findByNameContaining(keyword);
    }
}