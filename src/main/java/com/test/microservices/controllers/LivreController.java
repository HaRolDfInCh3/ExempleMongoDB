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

import com.test.microservices.pojos.Livre;
import com.test.microservices.repositories.LivresRepository;

@RestController
public class LivreController {
	LivresRepository livreRepo;
	public LivreController(LivresRepository repo) {
		this.livreRepo=repo;
		// TODO Auto-generated constructor stub
	}
@GetMapping("/getLivreByIdMongo/{id}")
public ResponseEntity<Livre> getLivre( @PathVariable String id) {
	if(livreRepo.existsByIdMongo(id)) {
		Livre ab=livreRepo.findByIdMongo( id);
		return new ResponseEntity<Livre>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Livre>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getLivreById/{id}")
public ResponseEntity<Livre> getLivre( @PathVariable int id) {
	if(livreRepo.existsById(id)) {
		Livre ab=livreRepo.findById( id);
		return new ResponseEntity<Livre>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Livre>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getAllLivres")
public ResponseEntity<List<Livre>> getLivre( ) {
	List<Livre> lab=livreRepo.findAll();
	return new ResponseEntity<List<Livre>>(lab,HttpStatus.OK);
}
@PostMapping("/addLivre")
public ResponseEntity<Livre> addLivre(@RequestBody Livre ab) {
	if(!livreRepo.existsById(ab.getId())) {
		livreRepo.save(ab);
		return new ResponseEntity<Livre>(ab,HttpStatus.CREATED);
	}
	return new ResponseEntity<Livre>(HttpStatus.CONFLICT);
}
@PutMapping("/updateLivre/{id}")
public ResponseEntity<Livre> updateLivre(@PathVariable int id,@RequestBody Livre ab) {
	if(livreRepo.existsById(id)) {
		livreRepo.save(ab);
		return new ResponseEntity<Livre>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Livre>(HttpStatus.NOT_FOUND);
}
@DeleteMapping("/deleteLivre/{id}")
public ResponseEntity<Livre> deleteLivre(@PathVariable int id) {
	if(livreRepo.existsById(id)) {
		Livre ab=livreRepo.deleteById(id);
		return new ResponseEntity<Livre>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Livre>(HttpStatus.NOT_FOUND);
}


}
