package com.example.OlympicsDemo.service;

import com.example.OlympicsDemo.dao.PlayerRepository;
import com.example.OlympicsDemo.entity.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerServiceImpl implements PlayerService {

	private PlayerRepository playerRepository;
	
	@Autowired
	public PlayerServiceImpl(PlayerRepository thePlayerRepository) {
		playerRepository = thePlayerRepository;
	}
	
	@Override
	public List<Player> findAll() {
		return playerRepository.findAll();
	}

	@Override
	public Player findById(int theId) {
		Optional<Player> result = playerRepository.findById(theId);
		
		Player thePlayer = null;
		
		if (result.isPresent()) {
			thePlayer = result.get();
		}
		else {
			// we didn't find the player
			throw new RuntimeException("Did not find player id - " + theId);
		}
		
		return thePlayer;
	}

	@Override
	public void save(Player thePlayer) {
		playerRepository.save(thePlayer);
	}

	@Override
	public void deleteById(int theId) {
		playerRepository.deleteById(theId);
	}

}






