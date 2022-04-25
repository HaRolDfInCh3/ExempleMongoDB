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

import com.test.microservices.pojos.Evenement;
import com.test.microservices.repositories.EvenementsRepository;
@RestController
public class EvenementController {
	EvenementsRepository evenementRepo;
	public EvenementController(EvenementsRepository repo) {
		this.evenementRepo=repo;
		// TODO Auto-generated constructor stub
	}
@GetMapping("/getEvenementByIdMongo/{id}")
public ResponseEntity<Evenement> getEvenement( @PathVariable String id) {
	if(evenementRepo.existsByIdMongo(id)) {
		Evenement ab=evenementRepo.findByIdMongo( id);
		return new ResponseEntity<Evenement>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Evenement>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getEvenementById/{id}")
public ResponseEntity<Evenement> getEvenement( @PathVariable int id) {
	if(evenementRepo.existsById(id)) {
		Evenement ab=evenementRepo.findById( id);
		return new ResponseEntity<Evenement>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Evenement>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getAllEvenements")
public ResponseEntity<List<Evenement>> getEvenement( ) {
	List<Evenement> lab=evenementRepo.findAll();
	return new ResponseEntity<List<Evenement>>(lab,HttpStatus.OK);
}
@PostMapping("/addEvenement")
public ResponseEntity<Evenement> addEvenement(@RequestBody Evenement ab) {
	if(!evenementRepo.existsById(ab.getId())) {
		evenementRepo.save(ab);
		return new ResponseEntity<Evenement>(ab,HttpStatus.CREATED);
	}
	return new ResponseEntity<Evenement>(HttpStatus.CONFLICT);
}
@PutMapping("/updateEvenement/{id}")
public ResponseEntity<Evenement> updateEvenement(@PathVariable int id,@RequestBody Evenement ab) {
	if(evenementRepo.existsById(id)) {
		evenementRepo.save(ab);
		return new ResponseEntity<Evenement>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Evenement>(HttpStatus.NOT_FOUND);
}
@DeleteMapping("/deleteEvenement/{id}")
public ResponseEntity<Evenement> deleteEvenement(@PathVariable int id) {
	if(evenementRepo.existsById(id)) {
		Evenement ab=evenementRepo.deleteById(id);
		return new ResponseEntity<Evenement>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Evenement>(HttpStatus.NOT_FOUND);
}


}
