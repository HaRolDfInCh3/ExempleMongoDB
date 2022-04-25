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

import com.test.microservices.pojos.Pays;
import com.test.microservices.repositories.PaysRepository;

@RestController
public class PaysController {
	PaysRepository paysRepo;
	public PaysController(PaysRepository repo) {
		this.paysRepo=repo;
		// TODO Auto-generated constructor stub
	}
@GetMapping("/getPaysByIdMongo/{id}")
public ResponseEntity<Pays> getPays( @PathVariable String id) {
	if(paysRepo.existsByIdMongo(id)) {
		Pays ab=paysRepo.findByIdMongo( id);
		return new ResponseEntity<Pays>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Pays>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getPaysById/{id}")
public ResponseEntity<Pays> getPays( @PathVariable int id) {
	if(paysRepo.existsById(id)) {
		Pays ab=paysRepo.findById( id);
		return new ResponseEntity<Pays>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Pays>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getAllPayss")
public ResponseEntity<List<Pays>> getPays( ) {
	List<Pays> lab=paysRepo.findAll();
	return new ResponseEntity<List<Pays>>(lab,HttpStatus.OK);
}
@PostMapping("/addPays")
public ResponseEntity<Pays> addPays(@RequestBody Pays ab) {
	if(!paysRepo.existsById(ab.getId())) {
		paysRepo.save(ab);
		return new ResponseEntity<Pays>(ab,HttpStatus.CREATED);
	}
	return new ResponseEntity<Pays>(HttpStatus.CONFLICT);
}
@PutMapping("/updatePays/{id}")
public ResponseEntity<Pays> updatePays(@PathVariable int id,@RequestBody Pays ab) {
	if(paysRepo.existsById(id)) {
		paysRepo.save(ab);
		return new ResponseEntity<Pays>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Pays>(HttpStatus.NOT_FOUND);
}
@DeleteMapping("/deletePays/{id}")
public ResponseEntity<Pays> deletePays(@PathVariable int id) {
	if(paysRepo.existsById(id)) {
		Pays ab=paysRepo.deleteById(id);
		return new ResponseEntity<Pays>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Pays>(HttpStatus.NOT_FOUND);
}


}
