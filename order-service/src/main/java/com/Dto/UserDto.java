package com.Dto;

import javax.management.relation.Role;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class UserDto {

	private long id;

	private String username;

	private String email;

	@Enumerated(EnumType.STRING)

	private Role role;

	private String password;

	public UserDto() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}