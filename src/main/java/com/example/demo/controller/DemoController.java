package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.User;
import com.example.demo.repository.UserRepository;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

@RestController
public class DemoController {
	
	private static Logger LOG = LoggerFactory.getLogger(DemoController.class);
	
	@Autowired
	private UserRepository userRepository;

	@GetMapping("/value")
	public ResponseEntity<String> getHello() {
		return new ResponseEntity<>("Hello World", HttpStatus.ACCEPTED);
	}

	@Cacheable(value = "users", key = "#userId")
	@RequestMapping(value = "/{userId}", method = RequestMethod.GET)
	public User getUser(@PathVariable String userId) {
		LOG.info("Getting user with ID {}.", userId);
	  return userRepository.findById(Long.valueOf(userId));
	}
	
	@CachePut(value = "users", key = "#user.id")
	@PutMapping("/update")
	public User updatePersonByID(@RequestBody User user) {
	  userRepository.save(user);
	  return user;
	}
	
	@CacheEvict(value = "users", allEntries=true)
	@DeleteMapping("/{id}")
	public void deleteUserByID(@PathVariable Long id) {
		LOG.info("deleting person with id {}", id);
		userRepository.deleteById(id);
	}
}
