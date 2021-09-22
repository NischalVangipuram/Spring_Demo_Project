package com.example.OlympicsDemo.dto;

import com.example.OlympicsDemo.entity.Country;
import com.example.OlympicsDemo.entity.Games;
import com.example.OlympicsDemo.entity.Player;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class PlayerDTO
{

         // define fields

        @Id
        @GeneratedValue(strategy= GenerationType.IDENTITY)
        private int playerId;
        // PlayerId => player_id

        @NotNull(message = "is required")
        @Size(min=1,message = "is required")
        private String playerName;


        private Country country;
        public PlayerDTO(){}

        public PlayerDTO(int playerId, String playerName, Country country, List<Games> games) {
                this.playerId = playerId;
                this.playerName = playerName;
                this.country = country;
                this.games = games;
        }

        @ToString.Exclude
        private List<Games> games;

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
}
