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

import com.test.microservices.pojos.Pari_resultat;
import com.test.microservices.repositories.Pari_resultatRepository;

@RestController
public class PariResultatController {
	Pari_resultatRepository prRepo;
	public PariResultatController(Pari_resultatRepository repo) {
		this.prRepo=repo;
		// TODO Auto-generated constructor stub
	}
@GetMapping("/getPari_resultatByIdMongo/{id}")
public ResponseEntity<Pari_resultat> getPari_resultat( @PathVariable String id) {
	if(prRepo.existsByIdMongo(id)) {
		Pari_resultat ab=prRepo.findByIdMongo( id);
		return new ResponseEntity<Pari_resultat>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Pari_resultat>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getPari_resultatById/{id}")
public ResponseEntity<Pari_resultat> getPari_resultat( @PathVariable int id) {
	if(prRepo.existsById(id)) {
		Pari_resultat ab=prRepo.findById( id);
		return new ResponseEntity<Pari_resultat>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Pari_resultat>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getAllPari_resultats")
public ResponseEntity<List<Pari_resultat>> getPari_resultat( ) {
	List<Pari_resultat> lab=prRepo.findAll();
	return new ResponseEntity<List<Pari_resultat>>(lab,HttpStatus.OK);
}
@PostMapping("/addPari_resultat")
public ResponseEntity<Pari_resultat> addPari_resultat(@RequestBody Pari_resultat ab) {
	if(!prRepo.existsById(ab.getId())) {
		prRepo.save(ab);
		return new ResponseEntity<Pari_resultat>(ab,HttpStatus.CREATED);
	}
	return new ResponseEntity<Pari_resultat>(HttpStatus.CONFLICT);
}
@PutMapping("/updatePari_resultat/{id}")
public ResponseEntity<Pari_resultat> updatePari_resultat(@PathVariable int id,@RequestBody Pari_resultat ab) {
	if(prRepo.existsById(id)) {
		prRepo.save(ab);
		return new ResponseEntity<Pari_resultat>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Pari_resultat>(HttpStatus.NOT_FOUND);
}
@DeleteMapping("/deletePari_resultat/{id}")
public ResponseEntity<Pari_resultat> deletePari_resultat(@PathVariable int id) {
	if(prRepo.existsById(id)) {
		Pari_resultat ab=prRepo.deleteById(id);
		return new ResponseEntity<Pari_resultat>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Pari_resultat>(HttpStatus.NOT_FOUND);
}


}
