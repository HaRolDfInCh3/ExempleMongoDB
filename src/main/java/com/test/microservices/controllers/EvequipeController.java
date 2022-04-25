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

import com.test.microservices.pojos.Evequipe;
import com.test.microservices.repositories.EvequipeRepository;
@RestController
public class EvequipeController {
	EvequipeRepository evequipeRepo;
	public EvequipeController(EvequipeRepository repo) {
		this.evequipeRepo=repo;
		// TODO Auto-generated constructor stub
	}
@GetMapping("/getEvequipeByIdMongo/{id}")
public ResponseEntity<Evequipe> getEvequipe( @PathVariable String id) {
	if(evequipeRepo.existsByIdMongo(id)) {
		Evequipe ab=evequipeRepo.findByIdMongo( id);
		return new ResponseEntity<Evequipe>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Evequipe>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getEvequipeById/{id}")
public ResponseEntity<Evequipe> getEvequipe( @PathVariable int id) {
	if(evequipeRepo.existsById(id)) {
		Evequipe ab=evequipeRepo.findById( id);
		return new ResponseEntity<Evequipe>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Evequipe>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getAllEvequipes")
public ResponseEntity<List<Evequipe>> getEvequipe( ) {
	List<Evequipe> lab=evequipeRepo.findAll();
	return new ResponseEntity<List<Evequipe>>(lab,HttpStatus.OK);
}
@PostMapping("/addEvequipe")
public ResponseEntity<Evequipe> addEvequipe(@RequestBody Evequipe ab) {
	if(!evequipeRepo.existsById(ab.getId())) {
		evequipeRepo.save(ab);
		return new ResponseEntity<Evequipe>(ab,HttpStatus.CREATED);
	}
	return new ResponseEntity<Evequipe>(HttpStatus.CONFLICT);
}
@PutMapping("/updateEvequipe/{id}")
public ResponseEntity<Evequipe> updateEvequipe(@PathVariable int id,@RequestBody Evequipe ab) {
	if(evequipeRepo.existsById(id)) {
		evequipeRepo.save(ab);
		return new ResponseEntity<Evequipe>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Evequipe>(HttpStatus.NOT_FOUND);
}
@DeleteMapping("/deleteEvequipe/{id}")
public ResponseEntity<Evequipe> deleteEvequipe(@PathVariable int id) {
	if(evequipeRepo.existsById(id)) {
		Evequipe ab=evequipeRepo.deleteById(id);
		return new ResponseEntity<Evequipe>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Evequipe>(HttpStatus.NOT_FOUND);
}


}
