package com.arshad.blogapi.users.dtos;

import org.springframework.lang.NonNull;

import lombok.Data;

@Data
public class LoginUserRequest {
    @NonNull
    private String username;
    public LoginUserRequest() {
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public LoginUserRequest(String username, String password) {
		this.username = username;
		this.password = password;
	}
	@NonNull
    private String password;
}
