package com.quest.etna.model;

import javax.persistence.*;

import javax.validation.constraints.*;


@Entity
@Table(name = "\"user\"")
public class UserDetails {
	
	@Id
	@NotEmpty(message = "username is mandatory")
	@Column(name = "username", unique=true, length = 255, nullable = false)
	private String username;
	
	@Column(name = "role")
	private String role = "ROLE_USER";
	
	public UserDetails() {};
	
	public UserDetails(String username, String role) {
		this.username = username;
		if (role != null) {
			this.role = role;
		}
	}
	
	public void setUsername(String username) {
		this.username = username;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getUsername() {
		return this.username;
	}
	
	public String getRole() {
		return this.role;
	}
}
