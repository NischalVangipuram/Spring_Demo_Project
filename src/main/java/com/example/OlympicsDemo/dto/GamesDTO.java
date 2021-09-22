package com.example.OlympicsDemo.dto;

import com.example.OlympicsDemo.entity.Country;
import com.example.OlympicsDemo.entity.Games;
import com.example.OlympicsDemo.entity.Player;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
public class GamesDTO
{

        @Id
        @GeneratedValue(strategy= GenerationType.IDENTITY)
        private int gameId;

       private String gameName;

    @ToString.Exclude
    private List<Player> players;

    public GamesDTO(){}

    public GamesDTO(int gameId, String gameName, List<Player> players) {
        this.gameId = gameId;
        this.gameName = gameName;
        this.players = players;
    }
}
