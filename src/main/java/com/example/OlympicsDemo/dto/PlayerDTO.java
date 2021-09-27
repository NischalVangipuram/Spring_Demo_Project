package com.example.OlympicsDemo.dto;

import com.example.OlympicsDemo.entity.Country;
import com.example.OlympicsDemo.entity.Games;
import com.example.OlympicsDemo.entity.Player;
import com.example.OlympicsDemo.entity.User;
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
//        public PlayerDTO(){}
//
//        public PlayerDTO(int playerId, String playerName, Country country, List<Games> games) {
//                this.playerId = playerId;
//                this.playerName = playerName;
//                this.country = country;
//                this.games = games;
//        }

        @ToString.Exclude
        private List<Games> games;

        private User user;




}
