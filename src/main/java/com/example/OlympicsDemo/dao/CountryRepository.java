package com.example.OlympicsDemo.dao;

import com.example.OlympicsDemo.entity.Country;
import com.example.OlympicsDemo.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Integer>
{


}

