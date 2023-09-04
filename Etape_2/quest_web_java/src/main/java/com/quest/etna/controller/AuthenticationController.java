package com.quest.etna.controller;

import java.util.Date;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.quest.etna.model.UserDetails;
import com.quest.etna.model.User;
import com.quest.etna.model.User.UserRole;
import com.quest.etna.repositories.UserRepository;

@RestController
public class AuthenticationController {
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping(value = "/register", produces = "application/json")
	public ResponseEntity<Object> register(@Valid @RequestBody User userJson) {
		User user = new User();
		
		try {
		user.setPassword(userJson.getPassword());
		user.setUsername(userJson.getUsername());
		Date now = new Date();
		user.setRole(UserRole.ROLE_USER.toString());
		user.setCreationDate(now);
		user.setUpdatedDate(now);
		System.out.print("Creation attempt for the user : " + user.toString() + "\n");
		userRepository.save(user);
		}
		catch(Exception e) {
			String arr[] = e.getCause().getCause().getMessage().toString().split(" ", 2);
			if ( arr[0].equals("Duplicate")) {
				return new ResponseEntity<>(e, HttpStatus.CONFLICT);
			}
			return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
			
		}
		
		UserDetails userDetails = new UserDetails();
		userDetails.setUsername(user.getUsername());
		userDetails.setRole(user.getRole());
		return new ResponseEntity<>(userDetails, HttpStatus.CREATED);
	}
	
}
