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

import com.test.microservices.pojos.Pari_user;
import com.test.microservices.repositories.Pari_userRepository;

@RestController
public class PariUserController {
	Pari_userRepository puRepo;
	public PariUserController(Pari_userRepository repo) {
		this.puRepo=repo;
		// TODO Auto-generated constructor stub
	}
@GetMapping("/getPari_userByIdMongo/{id}")
public ResponseEntity<Pari_user> getPari_user( @PathVariable String id) {
	if(puRepo.existsByIdMongo(id)) {
		Pari_user ab=puRepo.findByIdMongo( id);
		return new ResponseEntity<Pari_user>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Pari_user>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getPari_userById/{id}")
public ResponseEntity<Pari_user> getPari_user( @PathVariable int id) {
	if(puRepo.existsById(id)) {
		Pari_user ab=puRepo.findById( id);
		return new ResponseEntity<Pari_user>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Pari_user>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getAllPari_users")
public ResponseEntity<List<Pari_user>> getPari_user( ) {
	List<Pari_user> lab=puRepo.findAll();
	return new ResponseEntity<List<Pari_user>>(lab,HttpStatus.OK);
}
@PostMapping("/addPari_user")
public ResponseEntity<Pari_user> addPari_user(@RequestBody Pari_user ab) {
	if(!puRepo.existsById(ab.getId())) {
		puRepo.save(ab);
		return new ResponseEntity<Pari_user>(ab,HttpStatus.CREATED);
	}
	return new ResponseEntity<Pari_user>(HttpStatus.CONFLICT);
}
@PutMapping("/updatePari_user/{id}")
public ResponseEntity<Pari_user> updatePari_user(@PathVariable int id,@RequestBody Pari_user ab) {
	if(puRepo.existsById(id)) {
		puRepo.save(ab);
		return new ResponseEntity<Pari_user>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Pari_user>(HttpStatus.NOT_FOUND);
}
@DeleteMapping("/deletePari_user/{id}")
public ResponseEntity<Pari_user> deletePari_user(@PathVariable int id) {
	if(puRepo.existsById(id)) {
		Pari_user ab=puRepo.deleteById(id);
		return new ResponseEntity<Pari_user>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Pari_user>(HttpStatus.NOT_FOUND);
}


}
