package com.example.OlympicsDemo.service;

import com.example.OlympicsDemo.entity.Authority;
import com.example.OlympicsDemo.entity.User;

import java.util.List;

public interface AuthorityService {

	public List<Authority> findAll();
	
	public Authority findById(int theId);
	
	public void save(Authority theAuthority);
	
	public void deleteById(int theId);
	
}
