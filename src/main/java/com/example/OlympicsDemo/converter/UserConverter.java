package com.example.OlympicsDemo.converter;

import com.example.OlympicsDemo.dto.UserDTO;
import com.example.OlympicsDemo.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserConverter {



        public UserDTO entityToDto(User user)
        {
            ModelMapper mapper=new ModelMapper();
            UserDTO map=mapper.map(user,UserDTO.class);
            return map;
        }
        public User dtoToEntity(UserDTO userDTO)
        {
            ModelMapper mapper=new ModelMapper();
            User map=mapper.map(userDTO,User.class);
            return map;
        }
        public List<UserDTO> entityToDto(List<User> users)
        {
            return  users.stream().map(x->entityToDto(x)).collect(Collectors.toList());

        }
        public List<User> dtoToEntity(List<UserDTO> userDTOList){

            return userDTOList.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
        }

    }


