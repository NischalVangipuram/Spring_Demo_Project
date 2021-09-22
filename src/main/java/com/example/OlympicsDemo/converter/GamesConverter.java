package com.example.OlympicsDemo.converter;

import com.example.OlympicsDemo.dto.GamesDTO;
import com.example.OlympicsDemo.entity.Games;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GamesConverter {



        public GamesDTO entityToDto(Games games)
        {
            ModelMapper mapper=new ModelMapper();
            GamesDTO map=mapper.map(games,GamesDTO.class);
            return map;
        }
        public Games dtoToEntity(GamesDTO gamesDTO)
        {
            ModelMapper mapper=new ModelMapper();
            Games map=mapper.map(gamesDTO,Games.class);
            return map;
        }
        public List<GamesDTO> entityToDto(List<Games> games)
        {
            return  games.stream().map(x->entityToDto(x)).collect(Collectors.toList());

        }
        public List<Games> dtoToEntity(List<GamesDTO> gamesDTOList){

            return gamesDTOList.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
        }

    }


