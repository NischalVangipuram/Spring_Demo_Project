package com.example.OlympicsDemo.rest;

import com.example.OlympicsDemo.entity.Player;
import com.example.OlympicsDemo.service.PlayerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PlayerRestController {

	private PlayerService playerService;
	
	@Autowired
	public PlayerRestController(PlayerService thePlayerService) {
		playerService = thePlayerService;
	}
	
	// expose "/players" and return list of players
	@GetMapping("/players")
	public List<Player> findAll() {
		System.out.println("hllo get");
		return playerService.findAll();
	}

	// add mapping for GET /players/{PlayerId}
	
	@GetMapping("/players/{playerId}")
	public Player getPlayer(@PathVariable int playerId) {
		
		Player thePlayer = playerService.findById(playerId);
		
		if (thePlayer == null) {
			throw new RuntimeException("Player id not found - " + playerId);
		}
		
		return thePlayer;
	}
	
	// add mapping for POST /player - add new players
	
	@PostMapping("/players")
	public Player addPlayers(@RequestBody Player thePlayer)
	{
		System.out.println("hi post");
		// also just in case they pass an id in JSON ... set id to 0
		// this is to force a save of new item ... instead of update
		System.out.println("out "+thePlayer);
		thePlayer.setPlayerId(0);
		
		playerService.save(thePlayer);
		
		return thePlayer;
	}
	// add mapping for PUT /Players - update existing Player
	
	@PutMapping("/players")
	public Player updatePlayers(@RequestBody Player thePlayer) {
		
		playerService.save(thePlayer);
		
		return thePlayer;
	}
	
	// add mapping for DELETE /players/{playerId} - delete players
	
	@DeleteMapping("/players/{playerId}")
	public String deletePlayer(@PathVariable int playerId) {
		
		Player tempPlayer = playerService.findById(playerId);
		
		// throw exception if null
		
		if (tempPlayer == null) {
			throw new RuntimeException("player id not found - " + playerId);
		}
		
		playerService.deleteById(playerId);
		
		return "Deleted Player id - " + playerId;
	}
	
}










