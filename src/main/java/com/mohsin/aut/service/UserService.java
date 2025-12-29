package com.mohsin.aut.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mohsin.aut.entity.User;
import com.mohsin.aut.repository.UserRepository;


@Service
public class UserService {
	
	private final UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	/**
	 * @param userRepository
	 */
	public UserService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	
	public void registraterUser(String username, String password) {
		// user register here
		User user = new User();
		user.setUsername(username);
		user.setPassword(passwordEncoder.encode(password));
		user.setRole("User");
		userRepository.save(user);
		
	}
	

}
