package com.example.demo.repository.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.example.demo.models.User;
import com.example.demo.repository.UserRepository;

import jakarta.annotation.PostConstruct;

@Component
public class UserRepositoryImpl implements UserRepository{
	
	Map<Long, User> users = null;
	
	@PostConstruct
	public void init() {
		users = new HashMap<>();
	    User shubham = new User("Shubham", 2000L);
	    User pankaj = new User("Pankaj", 29000L);
	    User lewis = new User("Lewis", 550L);
	    
	    users.put(2000L, shubham);
	    users.put(29000L, pankaj);
	    users.put(550L, lewis);
	}

	@Override
	public User findById(Long valueOf) {
		return users.get(valueOf);
	}

	@Override
	public void save(User user) {
		users.put(user.getId(), user);
		
	}

	@Override
	public void deleteById(Long id) {
		users.remove(id);
		
	}

}
