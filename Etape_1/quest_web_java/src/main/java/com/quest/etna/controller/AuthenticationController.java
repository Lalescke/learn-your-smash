package com.quest.etna.controller;

import java.sql.SQLException;
import java.util.Date;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.support.SQLErrorCodes;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.quest.etna.model.UserDetails;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.quest.etna.model.User;
import com.quest.etna.model.User.UserRole;
import com.quest.etna.repositories.UserRepository;

@RestController
public class AuthenticationController {
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping(value = "/register", produces = "application/json")
	public ResponseEntity<UserDetails> register(@RequestBody Map<String, Object> userInfo) {
		User user = new User();
		
		try {
		user.setPassword(userInfo.get("password").toString());
		user.setUsername(userInfo.get("username").toString());
		Date now = new Date();
		user.setRole(UserRole.ROLE_USER);
		user.setCreationDate(now);
		user.setUpdatedDate(now);
		userRepository.save(user);
		}
		catch(Exception e) {
			String arr[] = e.getCause().getCause().getMessage().toString().split(" ", 2);
			if ( arr[0].equals("Duplicate")) {
				return new ResponseEntity(e.getCause().getCause().getMessage(), HttpStatus.CONFLICT);
			}
			return new ResponseEntity(e.getCause().getCause().getMessage(), HttpStatus.BAD_REQUEST);
			
		}
		
		UserDetails userDetails = new UserDetails();
		userDetails.setUsername(user.getUsername());
		userDetails.setRole(user.getRole());
		return new ResponseEntity<UserDetails>(userDetails, HttpStatus.CREATED);
	}
	
}
