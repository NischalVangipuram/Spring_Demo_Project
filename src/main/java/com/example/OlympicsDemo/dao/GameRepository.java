package com.example.OlympicsDemo.dao;

import com.example.OlympicsDemo.entity.Country;
import com.example.OlympicsDemo.entity.Games;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Games, Integer>
{


}

