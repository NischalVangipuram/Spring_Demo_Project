package com.example.OlympicsDemo.service;

import com.example.OlympicsDemo.dao.CountryRepository;
import com.example.OlympicsDemo.entity.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService
{


    private CountryRepository countryRepository;

    @Autowired
    public CountryServiceImpl(CountryRepository theCountryRepository) {
        countryRepository = theCountryRepository;
    }

    @Override
    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    @Override
    public Country findById(int theId) {
        Optional<Country> result = countryRepository.findById(theId);

        Country theCountry = null;

        if (result.isPresent()) {
            theCountry = result.get();
        }
        else {
            // we didn't find the Country
            throw new RuntimeException("Did not find Country id - " + theId);
        }

        return theCountry;
    }

    @Override
    public void save(Country theCountry) {
        countryRepository.save(theCountry);
    }

    @Override
    public void deleteById(int theId) {
        countryRepository.deleteById(theId);
    }

}








