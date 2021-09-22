package com.example.OlympicsDemo.service;

import com.example.OlympicsDemo.entity.Country;

import java.util.List;

public interface CountryService {

    public List<Country> findAll();

    public Country findById(int theId);

    public void save(Country theCountry);

    public void deleteById(int theId);

}