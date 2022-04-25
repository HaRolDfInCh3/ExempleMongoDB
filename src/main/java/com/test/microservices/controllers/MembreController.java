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

import com.test.microservices.pojos.Membre;
import com.test.microservices.repositories.MembreRepository;

@RestController
public class MembreController {
	MembreRepository membreRepo;
	public MembreController(MembreRepository repo) {
		this.membreRepo=repo;
		// TODO Auto-generated constructor stub
	}
@GetMapping("/getMembreByIdMongo/{id}")
public ResponseEntity<Membre> getMembre( @PathVariable String id) {
	if(membreRepo.existsByIdMongo(id)) {
		Membre ab=membreRepo.findByIdMongo( id);
		return new ResponseEntity<Membre>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Membre>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getMembreById/{id}")
public ResponseEntity<Membre> getMembre( @PathVariable int id) {
	if(membreRepo.existsById(id)) {
		Membre ab=membreRepo.findById( id);
		return new ResponseEntity<Membre>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Membre>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getAllMembres")
public ResponseEntity<List<Membre>> getMembre( ) {
	List<Membre> lab=membreRepo.findAll();
	return new ResponseEntity<List<Membre>>(lab,HttpStatus.OK);
}
@PostMapping("/addMembre")
public ResponseEntity<Membre> addMembre(@RequestBody Membre ab) {
	if(!membreRepo.existsById(ab.getId())) {
		membreRepo.save(ab);
		return new ResponseEntity<Membre>(ab,HttpStatus.CREATED);
	}
	return new ResponseEntity<Membre>(HttpStatus.CONFLICT);
}
@PutMapping("/updateMembre/{id}")
public ResponseEntity<Membre> updateMembre(@PathVariable int id,@RequestBody Membre ab) {
	if(membreRepo.existsById(id)) {
		membreRepo.save(ab);
		return new ResponseEntity<Membre>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Membre>(HttpStatus.NOT_FOUND);
}
@DeleteMapping("/deleteMembre/{id}")
public ResponseEntity<Membre> deleteMembre(@PathVariable int id) {
	if(membreRepo.existsById(id)) {
		Membre ab=membreRepo.deleteById(id);
		return new ResponseEntity<Membre>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Membre>(HttpStatus.NOT_FOUND);
}


}
