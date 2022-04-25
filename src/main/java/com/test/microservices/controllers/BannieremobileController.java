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

import com.test.microservices.pojos.Bannieremobile;
import com.test.microservices.repositories.BmRepository;
@RestController
public class BannieremobileController {
	BmRepository bmRepo;
	public BannieremobileController(BmRepository repo) {
		this.bmRepo=repo;
		// TODO Auto-generated constructor stub
	}
@GetMapping("/getBannieremobileByIdMongo/{id}")
public ResponseEntity<Bannieremobile> getBannieremobile( @PathVariable String id) {
	if(bmRepo.existsByIdMongo(id)) {
		Bannieremobile ab=bmRepo.findByIdMongo( id);
		return new ResponseEntity<Bannieremobile>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Bannieremobile>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getBannieremobileById/{id}")
public ResponseEntity<Bannieremobile> getBannieremobile( @PathVariable int id) {
	if(bmRepo.existsById(id)) {
		Bannieremobile ab=bmRepo.findById( id);
		return new ResponseEntity<Bannieremobile>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Bannieremobile>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getAllBannieremobiles")
public ResponseEntity<List<Bannieremobile>> getBannieremobile( ) {
	List<Bannieremobile> lab=bmRepo.findAll();
	return new ResponseEntity<List<Bannieremobile>>(lab,HttpStatus.OK);
}
@PostMapping("/addBannieremobile")
public ResponseEntity<Bannieremobile> addBannieremobile(@RequestBody Bannieremobile ab) {
	if(!bmRepo.existsById(ab.getId())) {
		bmRepo.save(ab);
		return new ResponseEntity<Bannieremobile>(ab,HttpStatus.CREATED);
	}
	return new ResponseEntity<Bannieremobile>(HttpStatus.CONFLICT);
}
@PutMapping("/updateBannieremobile/{id}")
public ResponseEntity<Bannieremobile> updateBannieremobile(@PathVariable int id,@RequestBody Bannieremobile ab) {
	if(bmRepo.existsById(id)) {
		bmRepo.save(ab);
		return new ResponseEntity<Bannieremobile>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Bannieremobile>(HttpStatus.NOT_FOUND);
}
@DeleteMapping("/deleteBannieremobile/{id}")
public ResponseEntity<Bannieremobile> deleteBannieremobile(@PathVariable int id) {
	if(bmRepo.existsById(id)) {
		Bannieremobile ab=bmRepo.deleteById(id);
		return new ResponseEntity<Bannieremobile>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Bannieremobile>(HttpStatus.NOT_FOUND);
}

}
