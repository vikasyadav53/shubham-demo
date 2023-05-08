package com.example.demo.repository;

import com.example.demo.models.User;

public interface UserRepository {

	User findById(Long valueOf);

	void save(User user);

	void deleteById(Long id);

}
