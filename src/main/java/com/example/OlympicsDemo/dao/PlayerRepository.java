package com.example.OlympicsDemo.dao;

import com.example.OlympicsDemo.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Integer> {


}

