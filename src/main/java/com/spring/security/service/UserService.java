package com.spring.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.security.dao.UserRepo;
import com.spring.security.entity.User;

@Service
public class UserService {
	
	@Autowired
    private UserRepo userRepo;
	
//	@Autowired
//	private BCryptPasswordEncoder encoder;
//	
	public User save(User user) {
		user.setPassword(new BCryptPasswordEncoder(12).encode(user.getPassword()));
		User userRes=	userRepo.save(user);
		return userRes;
	}
}
