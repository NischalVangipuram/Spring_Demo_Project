package com.example.OlympicsDemo.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.engine.internal.Cascade;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
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

	//@NotNull(message = "Name is required")
	@Column(name="player_name")
	@Size(min=1,message = "is required")
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

	@ToString.Exclude
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="user_id")
	@Valid
	private User user;

	// define constructors
	
	public Player()
	{
		
	}


}











