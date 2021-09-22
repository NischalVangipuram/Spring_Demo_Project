package com.example.OlympicsDemo.converter;

import ch.qos.logback.core.spi.FilterReply;
import com.example.OlympicsDemo.dto.PlayerDTO;
import com.example.OlympicsDemo.entity.Player;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PlayerConverter {



        public PlayerDTO entityToDto(Player player)
        {
            ModelMapper mapper=new ModelMapper();
            PlayerDTO map=mapper.map(player,PlayerDTO.class);
            return map;
        }
        public Player dtoToEntity(PlayerDTO playerDTO)
        {
            ModelMapper mapper=new ModelMapper();
            Player map=mapper.map(playerDTO,Player.class);
            return map;
        }
        public List<PlayerDTO> entityToDto(List<Player> players)
        {
            return  players.stream().map(x->entityToDto(x)).collect(Collectors.toList());

        }
        public List<Player> dtoToEntity(List<PlayerDTO> playerDTOList){

            return playerDTOList.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
        }

    }


