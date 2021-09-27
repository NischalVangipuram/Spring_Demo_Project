package com.example.OlympicsDemo.entity;

import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
@Table(name="users")
public class User {

	@Column(name = "username")
	@NotNull(message = "Username Required")
	@Pattern(regexp = "[^0-9]*",message = "Numbers not allowed")
	private String username;

	@NotNull(message = "Password is required")
	@Column(name = "password")
	@Size(min = 1, message = "is required")
	private String password;

	@Column(name = "enabled")
	private int enabled;

	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;


	@ToString.Exclude
	@OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
	private Player thePlayer;


	@ToString.Exclude
	@ManyToOne()
	@JoinColumn(name="authority_id")
	private Authority theAuthority;


	public User() {
	}

	public User(String username, String password, int enabled, int userId, Player thePlayer, Authority theAuthority) {
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.userId = userId;
		this.thePlayer = thePlayer;
		this.theAuthority = theAuthority;
	}

}











