package com.example.OlympicsDemo.entity;

import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@ToString
@Entity
@Table(name="Players")
public class Player {

	// define fields
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="player_id")
	private int playerId;
	// PlayerId => player_id

	@NotNull(message = "Name is required")
	@Column(name="player_name")
	@Size(min=1,message = "is required")
	@Pattern(regexp = "[^0-9]*",message = "Numbers not allowed")
	private String playerName;

	@NotNull(message = "is required")
	@ManyToOne()
	@JoinColumn(name="country_id")
	private Country country;

	@NotNull(message = "Games required")
	@ToString.Exclude
	@ManyToMany
	@JoinTable(name="players_has_games",
			joinColumns = @JoinColumn(name="players_player_id"),
			inverseJoinColumns = @JoinColumn(name="games_games_id"))
	private List<Games> games;

	// define constructors
	
	public Player()
	{
		
	}



	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public List<Games> getGames() {
		return games;
	}

	public void setGames(List<Games> games) {
		this.games = games;
	}

	public void addGame(List<Games> gamesList)
	{

		games=gamesList;
	}


}











