package com.quest.etna.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.quest.etna.model.User.UserRole;

@Entity
@Table(name = "user")
public class UserDetails {
	
	@Id
	@Column(name = "username")
	private String username;
	
	@Column(name = "role")
	private UserRole role;
	
	public UserDetails() {};
	
	public UserDetails(String username, UserRole role) {
		this.username = username;
		this.role = role;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}

	public String getUsername() {
		return this.username;
	}
	
	public UserRole getRole() {
		return this.role;
	}
}
