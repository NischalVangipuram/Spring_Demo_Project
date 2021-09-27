package com.example.OlympicsDemo.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
@Table(name="authorities")
public class Authority
{

	@Id
	@Column(name="authority_id")
	@NotNull(message = "Username Required")
	private int authorityId;


	@Column(name = "authority")
	private  String authority;

	@ToString.Exclude
	@OneToMany(mappedBy="theAuthority",
			cascade= {CascadeType.PERSIST, CascadeType.MERGE,
					CascadeType.DETACH, CascadeType.REFRESH})
	private List<User> users;

	public  Authority(){}

	public Authority(int authorityId) {
		this.authorityId = authorityId;
	}
}











