package com.CRUD.service;


import org.springframework.stereotype.Service;

import com.CRUD.entity.User;
import com.CRUD.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

	private final UserRepository userRepository;
	
	@Override
	public User createUser(User user) {
		
		return userRepository.save(user);
	}
	

}
