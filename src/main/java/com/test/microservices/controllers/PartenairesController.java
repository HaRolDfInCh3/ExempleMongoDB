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

import com.test.microservices.pojos.Partenaire;
import com.test.microservices.repositories.PartenairesRepository;

@RestController
public class PartenairesController {
	PartenairesRepository partenaireRepo;
	public PartenairesController(PartenairesRepository repo) {
		this.partenaireRepo=repo;
		// TODO Auto-generated constructor stub
	}
@GetMapping("/getPartenaireByIdMongo/{id}")
public ResponseEntity<Partenaire> getPartenaire( @PathVariable String id) {
	if(partenaireRepo.existsByIdMongo(id)) {
		Partenaire ab=partenaireRepo.findByIdMongo( id);
		return new ResponseEntity<Partenaire>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Partenaire>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getPartenaireById/{id}")
public ResponseEntity<Partenaire> getPartenaire( @PathVariable int id) {
	if(partenaireRepo.existsById(id)) {
		Partenaire ab=partenaireRepo.findById( id);
		return new ResponseEntity<Partenaire>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Partenaire>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getAllPartenaires")
public ResponseEntity<List<Partenaire>> getPartenaire( ) {
	List<Partenaire> lab=partenaireRepo.findAll();
	return new ResponseEntity<List<Partenaire>>(lab,HttpStatus.OK);
}
@PostMapping("/addPartenaire")
public ResponseEntity<Partenaire> addPartenaire(@RequestBody Partenaire ab) {
	if(!partenaireRepo.existsById(ab.getId())) {
		partenaireRepo.save(ab);
		return new ResponseEntity<Partenaire>(ab,HttpStatus.CREATED);
	}
	return new ResponseEntity<Partenaire>(HttpStatus.CONFLICT);
}
@PutMapping("/updatePartenaire/{id}")
public ResponseEntity<Partenaire> updatePartenaire(@PathVariable int id,@RequestBody Partenaire ab) {
	if(partenaireRepo.existsById(id)) {
		partenaireRepo.save(ab);
		return new ResponseEntity<Partenaire>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Partenaire>(HttpStatus.NOT_FOUND);
}
@DeleteMapping("/deletePartenaire/{id}")
public ResponseEntity<Partenaire> deletePartenaire(@PathVariable int id) {
	if(partenaireRepo.existsById(id)) {
		Partenaire ab=partenaireRepo.deleteById(id);
		return new ResponseEntity<Partenaire>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Partenaire>(HttpStatus.NOT_FOUND);
}


}
