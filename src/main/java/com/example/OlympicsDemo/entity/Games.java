package com.example.OlympicsDemo.entity;

import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@ToString
@Entity
@Table(name="games")
public class Games
{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="games_id")
    @NotNull(message = "Game Id required")
    private int gameId;

    @Column(name="games_name")
    @NotNull(message = "Game name required")
    private String gameName;


    @ToString.Exclude
    @ManyToMany
    @JoinTable(name="players_has_games",
    joinColumns = @JoinColumn(name="games_games_id"),
    inverseJoinColumns = @JoinColumn(name="players_player_id"))
    private List<Player> players;

    public  Games(){}

    public Games(int gameId, String gameName, List<Player> players) {
        this.gameId = gameId;
        this.gameName = gameName;
        this.players = players;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }


}
