package com.quest.etna.model;

import java.util.Date;
import java.util.Objects;

import javax.persistence.*;

import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "\"user\"")
public class User {
	
	public enum UserRole {
		ROLE_USER,
		ROLE_ADMIN
	}
	
	@Column(name = "id", unique=true)
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@NotEmpty(message = "username is mandatory")
	@Column(name = "username", unique=true, length = 255)
	private String username;
	
	@NotEmpty(message = "password is mandatory")
	@Column(name = "password", length = 255)
	private String password;
	
	@Column(name = "role", columnDefinition = "string default 'ROLE_USER'")
	private UserRole role;
	
	@CreationTimestamp
	@Column(name = "creation_date")
	private Date creation_date;
	
	@CreationTimestamp
	@Column(name = "updated_date")
	private Date updated_date;
	
	public User() {};
	
	public User(Integer id, String username, String password, UserRole role, Date creation_date, Date updated_date) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.role = role;
		this.creation_date = creation_date;
		this.updated_date = updated_date;
	}
	
	public Integer getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
		
	public String getUsername() {
		return this.username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public UserRole getRole() {
		return this.role;
	}
	
	public void setRole(UserRole role) {
		this.role = role;
	}
	
	public Date getCreationDate() {
		return this.creation_date;
	}
	
	public void setCreationDate(Date creation_date) {
		this.creation_date = creation_date;
	}
	
	public Date getUpdatedDate() {
		return this.updated_date;
	}
	
	public void setUpdatedDate(Date updated_date) {
		this.updated_date = updated_date;
	}
	

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", role=" + role
				+ ", creation_date=" + creation_date + ", updated_date=" + updated_date + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(creation_date, id, password, role, updated_date, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(creation_date, other.creation_date) && Objects.equals(id, other.id)
				&& Objects.equals(password, other.password) && role == other.role
				&& Objects.equals(updated_date, other.updated_date) && Objects.equals(username, other.username);
	}
}
