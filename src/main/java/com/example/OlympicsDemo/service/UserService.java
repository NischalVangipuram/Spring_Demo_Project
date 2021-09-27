package com.example.OlympicsDemo.service;

import com.example.OlympicsDemo.entity.User;

import java.util.List;

public interface UserService {

	public List<User> findAll();
	
	public User findById(int theId);
	
	public void save(User theUser);
	
	public void deleteById(int theId);

	public User findUsername(String s);

	
}
