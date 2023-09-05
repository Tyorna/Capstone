package com.example.demo.Controller;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.UserService;
import com.example.demo.entities.User;
import com.example.demo.payload.UserPayload;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public User saveUser(@RequestBody UserPayload body) {
		User createdUser = userService.save(body);
		return createdUser;
	}

	@GetMapping("/{userId}")
	public Optional<User> findById(@PathVariable UUID userId) {
		return userService.findById(userId);
	}

//	@PutMapping("/{userId}")
//	public User updateUser(@PathVariable UUID userId, @RequestBody UserPayload body) {
//		return userService.findByIdAndUpdate(userId, body);
//	}
//
//	@DeleteMapping("/{userId}")
//	@ResponseStatus(HttpStatus.NO_CONTENT)
//	public void deleteUser(@PathVariable UUID userId) {
//		userService.findByIdAndDelete(userId);
//	}
}
