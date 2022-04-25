package com.test.microservices.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.microservices.pojos.User;
import com.test.microservices.repositories.UsersRepository;

@RestController
public class UserController {
	UsersRepository userRepo;
	public UserController(UsersRepository repo) {
		this.userRepo=repo;
		// TODO Auto-generated constructor stub
	}
@GetMapping("/getUserByIdMongo/{id}")
public ResponseEntity<User> getUser( @PathVariable String id) {
	if(userRepo.existsByIdMongo(id)) {
		User ab=userRepo.findByIdMongo( id);
		return new ResponseEntity<User>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getUserById/{id}")
public ResponseEntity<User> getUser( @PathVariable int id) {
	if(userRepo.existsById(id)) {
		User ab=userRepo.findById( id);
		return new ResponseEntity<User>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getAllUsers")
public ResponseEntity<List<User>> getUser( ) {
	List<User> lab=userRepo.findAll();
	return new ResponseEntity<List<User>>(lab,HttpStatus.OK);
}
@PostMapping("/addUser")
public ResponseEntity<User> addUser(@RequestBody User ab) {
	if(!userRepo.existsById(ab.getId())) {
		userRepo.save(ab);
		return new ResponseEntity<User>(ab,HttpStatus.CREATED);
	}
	return new ResponseEntity<User>(HttpStatus.CONFLICT);
}
@PutMapping("/updateUser/{id}")
public ResponseEntity<User> updateUser(@PathVariable int id,@RequestBody User ab) {
	if(userRepo.existsById(id)) {
		userRepo.save(ab);
		return new ResponseEntity<User>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
}
@DeleteMapping("/deleteUser/{id}")
public ResponseEntity<User> deleteUser(@PathVariable int id) {
	if(userRepo.existsById(id)) {
		User ab=userRepo.deleteById(id);
		return new ResponseEntity<User>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
}


}

