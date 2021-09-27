package com.example.OlympicsDemo.service;

import com.example.OlympicsDemo.dao.AuthorityRepository;
import com.example.OlympicsDemo.dao.UserRepository;
import com.example.OlympicsDemo.entity.Authority;
import com.example.OlympicsDemo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorityServiceImpl implements AuthorityService {

	private AuthorityRepository authorityRepository;

	@Autowired
	public AuthorityServiceImpl(AuthorityRepository theAuthorityRepository) {
		 authorityRepository= theAuthorityRepository;
	}
	
	@Override
	public List<Authority> findAll() {
		return authorityRepository.findAll();
	}

	@Override
	public Authority findById(int theId) {
		Optional<Authority> result = authorityRepository.findById(theId);
		
		Authority theAuthority = null;
		
		if (result.isPresent()) {
			theAuthority = result.get();
		}
		else {
			// we didn't find the player
			throw new RuntimeException("Did not find player id - " + theId);
		}
		
		return theAuthority;
	}

	@Override
	public void save(Authority theAuthority) {
		authorityRepository.save(theAuthority);
	}

	@Override
	public void deleteById(int theId) {
		authorityRepository.deleteById(theId);
	}

}






