package com.example.demo.payload;

import java.util.UUID;

import com.example.demo.entities.User;

import lombok.Getter;

@Getter
public class LoginSuccessfullPayload {
	String accessToken;
	UUID id;
	String username;
	String email;

	public LoginSuccessfullPayload(String accessToken, User user) {
		this.accessToken = accessToken;
		this.id = user.getId();
		this.username = user.getUsername();
		this.email = user.getEmail();
	}

}
