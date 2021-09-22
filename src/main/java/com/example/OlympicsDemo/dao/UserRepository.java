package com.example.OlympicsDemo.dao;

import com.example.OlympicsDemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {


}

