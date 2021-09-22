package com.example.OlympicsDemo.dto;

import com.example.OlympicsDemo.entity.Country;
import com.example.OlympicsDemo.entity.Games;
import com.example.OlympicsDemo.entity.Player;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
public class CountryDTO
{

        @Id
        @GeneratedValue(strategy= GenerationType.IDENTITY)
        private int countryId;
        private String countryName;

        @ToString.Exclude
        private List<Player> players;
}
