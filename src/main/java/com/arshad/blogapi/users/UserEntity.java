package com.arshad.blogapi.users;

import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import jakarta.persistence.*;

@Entity(name = "users")
public class UserEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false)
    private Long id;

	@Column(nullable = false)
    @NonNull
    private String username;
	
	@Column(nullable = false)
    @NonNull
    private String password;

    @Column(nullable = false)
    @NonNull
    private String email;

    @Column(nullable = true)
    @Nullable
    private String bio;
	
	public UserEntity() {}
	
	public UserEntity(String username, String password, String email) {
		this.username = username;
		this.email = email;
		this.password = password;
	}

	public UserEntity(Long id, String username, String password, String email, String bio) {
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.bio = bio;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}
	
	@Override
	public String toString() {
		return "UserEntity [id=" + id + ", username=" + username + ", email=" + email + ", password=" + password
				+ ", bio=" + bio + "]";
	}

}
