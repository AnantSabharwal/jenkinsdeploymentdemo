package org.angularassignment.controller;

import java.util.List;
import java.util.Optional;

import org.angularassignment.entity.User;
import org.angularassignment.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins="http://localhost:4200")
public class UserController {
	@Autowired
	private UserRepository repo;
	
	@PostMapping
	public ResponseEntity<User> registerUser(@RequestBody User user){
		return ResponseEntity.of(Optional.of(this.repo.save(user)));
	}
	
	@GetMapping
	public ResponseEntity<List<User>> getAllUsers(){
		return ResponseEntity.of(Optional.of(this.repo.findAll()));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<User>> getUser(@PathVariable int id){
		return ResponseEntity.of(Optional.of(this.repo.findById(id)));
	}
	
	@PutMapping
	public ResponseEntity<User> updateUser(@RequestBody User user){
		return ResponseEntity.of(Optional.of(this.repo.save(user)));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteUser(@PathVariable int id){
		this.repo.deleteById(id);
		return ResponseEntity.ok(true);
	}
}
