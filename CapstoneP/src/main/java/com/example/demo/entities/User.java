package com.example.demo.entities;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class User{

	@Id
	@GeneratedValue
	private UUID id;
	private String username;
	@Column(nullable = false, unique = true)
	private String email;
	private String password;
	
	public User(String username, String email, String password) {

		this.username = username;
		this.email = email;
		this.password = password;
	}

}
