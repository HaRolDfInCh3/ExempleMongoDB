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

import com.test.microservices.pojos.Pari;
import com.test.microservices.repositories.PariRepository;

@RestController
public class PariController {
	PariRepository pRepo;
	public PariController(PariRepository repo) {
		this.pRepo=repo;
		// TODO Auto-generated constructor stub
	}
@GetMapping("/getPariByIdMongo/{id}")
public ResponseEntity<Pari> getPari( @PathVariable String id) {
	if(pRepo.existsByIdMongo(id)) {
		Pari ab=pRepo.findByIdMongo( id);
		return new ResponseEntity<Pari>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Pari>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getPariById/{id}")
public ResponseEntity<Pari> getPari( @PathVariable int id) {
	if(pRepo.existsById(id)) {
		Pari ab=pRepo.findById( id);
		return new ResponseEntity<Pari>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Pari>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getAllParis")
public ResponseEntity<List<Pari>> getPari( ) {
	List<Pari> lab=pRepo.findAll();
	return new ResponseEntity<List<Pari>>(lab,HttpStatus.OK);
}
@PostMapping("/addPari")
public ResponseEntity<Pari> addPari(@RequestBody Pari ab) {
	if(!pRepo.existsById(ab.getId())) {
		pRepo.save(ab);
		return new ResponseEntity<Pari>(ab,HttpStatus.CREATED);
	}
	return new ResponseEntity<Pari>(HttpStatus.CONFLICT);
}
@PutMapping("/updatePari/{id}")
public ResponseEntity<Pari> updatePari(@PathVariable int id,@RequestBody Pari ab) {
	if(pRepo.existsById(id)) {
		pRepo.save(ab);
		return new ResponseEntity<Pari>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Pari>(HttpStatus.NOT_FOUND);
}
@DeleteMapping("/deletePari/{id}")
public ResponseEntity<Pari> deletePari(@PathVariable int id) {
	if(pRepo.existsById(id)) {
		Pari ab=pRepo.deleteById(id);
		return new ResponseEntity<Pari>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Pari>(HttpStatus.NOT_FOUND);
}


}

