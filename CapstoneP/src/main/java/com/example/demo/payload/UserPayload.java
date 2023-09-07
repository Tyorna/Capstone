package com.example.demo.payload;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserPayload {

	@NotNull(message = "L'username è obbligatorio")
	private String username;
	@NotNull(message = "L'email è obbligatoria")
	@Email(message = "La password inserita non è valida")
	private String email;
	@NotNull(message = "La password è obbligatoria")
	private String password;

}
