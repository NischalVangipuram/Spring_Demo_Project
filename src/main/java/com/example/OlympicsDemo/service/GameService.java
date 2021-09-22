package com.example.OlympicsDemo.service;

import com.example.OlympicsDemo.entity.Games;

import java.util.List;

public interface GameService {

    public List<Games> findAll();

    public Games findById(int theId);

    public void save(Games theGame);

    public void deleteById(int theId);

}