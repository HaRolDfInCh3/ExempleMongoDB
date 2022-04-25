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

import com.test.microservices.pojos.Evenementimportants;
import com.test.microservices.repositories.EvenementimportantsRepository;
@RestController
public class EvenementimportantsController {
	EvenementimportantsRepository evenementimportantsRepo;
	public EvenementimportantsController(EvenementimportantsRepository repo) {
		this.evenementimportantsRepo=repo;
		// TODO Auto-generated constructor stub
	}
@GetMapping("/getEvenementimportantsByIdMongo/{id}")
public ResponseEntity<Evenementimportants> getEvenementimportants( @PathVariable String id) {
	if(evenementimportantsRepo.existsByIdMongo(id)) {
		Evenementimportants ab=evenementimportantsRepo.findByIdMongo( id);
		return new ResponseEntity<Evenementimportants>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Evenementimportants>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getEvenementimportantsById/{id}")
public ResponseEntity<Evenementimportants> getEvenementimportants( @PathVariable int id) {
	if(evenementimportantsRepo.existsById(id)) {
		Evenementimportants ab=evenementimportantsRepo.findById( id);
		return new ResponseEntity<Evenementimportants>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Evenementimportants>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getAllEvenementimportantss")
public ResponseEntity<List<Evenementimportants>> getEvenementimportants( ) {
	List<Evenementimportants> lab=evenementimportantsRepo.findAll();
	return new ResponseEntity<List<Evenementimportants>>(lab,HttpStatus.OK);
}
@PostMapping("/addEvenementimportants")
public ResponseEntity<Evenementimportants> addEvenementimportants(@RequestBody Evenementimportants ab) {
	if(!evenementimportantsRepo.existsById(ab.getId())) {
		evenementimportantsRepo.save(ab);
		return new ResponseEntity<Evenementimportants>(ab,HttpStatus.CREATED);
	}
	return new ResponseEntity<Evenementimportants>(HttpStatus.CONFLICT);
}
@PutMapping("/updateEvenementimportants/{id}")
public ResponseEntity<Evenementimportants> updateEvenementimportants(@PathVariable int id,@RequestBody Evenementimportants ab) {
	if(evenementimportantsRepo.existsById(id)) {
		evenementimportantsRepo.save(ab);
		return new ResponseEntity<Evenementimportants>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Evenementimportants>(HttpStatus.NOT_FOUND);
}
@DeleteMapping("/deleteEvenementimportants/{id}")
public ResponseEntity<Evenementimportants> deleteEvenementimportants(@PathVariable int id) {
	if(evenementimportantsRepo.existsById(id)) {
		Evenementimportants ab=evenementimportantsRepo.deleteById(id);
		return new ResponseEntity<Evenementimportants>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Evenementimportants>(HttpStatus.NOT_FOUND);
}


}
