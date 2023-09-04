package com.quest.etna.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultController {
	
	@GetMapping("/testSuccess")
	@ResponseStatus(HttpStatus.OK)
	public String testSuccess() {
		return "success";
	}
	
	@GetMapping("/testNotFound")
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String testNotFound() {
		return "not found";
	}
	
	@GetMapping("/testError")
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public String testError() {
		return "error";
	}
	
	@GetMapping("/createUser")
	@ResponseStatus(HttpStatus.CREATED)
	public String createUser() {

	    try {
			String query = "INSERT INTO user() VALUES(3, 'Georges', 'mdp', 'ROLE_ADMIN', '2023-03-19', '2023-03-22')";
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quest_web?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=UTC", "application", "password");
			Statement st = conn.createStatement();
			st.executeUpdate(query);
	    }
	    catch (Exception e) {
	    	return "Error in sql operation: " + e;
	    }
		return "Nice one!";
	}

}