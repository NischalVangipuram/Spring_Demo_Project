package com.example.OlympicsDemo.service;

import com.example.OlympicsDemo.dao.GameRepository;
import com.example.OlympicsDemo.entity.Games;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameServiceImpl implements GameService {

	private GameRepository gameRepository;

	@Autowired
	public GameServiceImpl(GameRepository theGameRepository) {
		gameRepository = theGameRepository;
	}
	
	@Override
	public List<Games> findAll() {
		return gameRepository.findAll();
	}

	@Override
	public Games findById(int theId) {
		Optional<Games> result = gameRepository.findById(theId);
		
		Games theGame = null;
		
		if (result.isPresent()) {
			theGame = result.get();
		}
		else {
			// we didn't find the player
			throw new RuntimeException("Did not find game id - " + theId);
		}
		
		return theGame;
	}

	@Override
	public void save(Games theGame) {
		gameRepository.save(theGame);
	}

	@Override
	public void deleteById(int theId) {
		gameRepository.deleteById(theId);
	}

}






