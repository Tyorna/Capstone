package com.example.demo.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.UserRepository;
import com.example.demo.entities.User;
import com.example.demo.payload.UserPayload;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public User save(UserPayload body) {
		userRepository.findByEmail(body.getEmail());
		User newUser = new User(body.getUsername(), body.getEmail(), body.getPassword());
		return userRepository.save(newUser);
	}

	public List<User> getUsers() {
		return userRepository.findAll();
	}

	public Page<User> find(int page, int size, String sort) {
		Pageable pageable = PageRequest.of(page, size, Sort.by(sort));

		return userRepository.findAll(pageable);
	}

	public Optional<User> findById(UUID id) {
		return userRepository.findById(id);
	}


//	public User findByIdAndUpdate(UUID id, UserPayload body){
//		User found = this.findById(id);
//		found.setEmail(body.getEmail());
//		return userRepository.save(found);
//	}
//
//	
//	public void findByIdAndDelete(UUID id){
//		User found = this.findById(id);
//		userRepository.delete(found);
//	}

	public Optional<User> findByEmail(String email) {
		return userRepository.findByEmail(email);
	}
}