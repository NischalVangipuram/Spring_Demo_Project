package com.example.OlympicsDemo.entity;

import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name="users")
public class User
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="username")
	@NotNull(message = "Username Required")
	private String username;

	@NotNull(message = "Password is required")
	@Column(name="password")
	@Size(min=1,message = "is required")
	private String password;

	@Column(name = "enabled")
	private int enabled;





}











