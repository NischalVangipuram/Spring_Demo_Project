package com.example.OlympicsDemo.dto;

import com.example.OlympicsDemo.entity.Player;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@ToString
@Data
public class UserDTO
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String username;


	private String password;

	private int enabled;
	private  int userId;

	@ToString.Exclude
	private Player player;





}











