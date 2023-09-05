package com.example.demo.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserPayload {
	
	private String username;
	private String email;
	private String password;

}


