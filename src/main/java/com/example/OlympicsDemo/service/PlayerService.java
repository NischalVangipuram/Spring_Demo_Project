package com.example.OlympicsDemo.service;

import com.example.OlympicsDemo.entity.Player;
import com.example.OlympicsDemo.entity.User;

import java.util.List;

public interface PlayerService {

	public List<Player> findAll();
	
	public Player findById(int theId);
	
	public void save(Player thePlayer);
	
	public void deleteById(int theId);

	public Player findPlayer(String s);

	public Player findPlayerByUser(User theUser);
	
}
