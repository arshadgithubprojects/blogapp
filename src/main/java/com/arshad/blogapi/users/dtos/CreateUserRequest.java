package com.arshad.blogapi.users.dtos;

import org.springframework.lang.NonNull;
import lombok.Data;

@Data
public class CreateUserRequest {
	
	public CreateUserRequest() {
	}
	
	public CreateUserRequest(String username, String password, String email) {
		this.username = username;
		this.password = password;
		this.email = email;
	}
	@NonNull
    private String username;
    @NonNull
    private String password;
    @NonNull
    private String email;
	
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
