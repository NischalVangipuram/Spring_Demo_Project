package com.example.OlympicsDemo.dao;

import com.example.OlympicsDemo.entity.Player;
import com.example.OlympicsDemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Integer> {

    public Player findByPlayerName(String s);
    public Player findByUser(User user);
}

