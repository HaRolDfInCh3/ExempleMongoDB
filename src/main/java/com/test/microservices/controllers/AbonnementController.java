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

import com.test.microservices.pojos.Abonnement;
import com.test.microservices.repositories.AbonnementRepository;

@RestController
public class AbonnementController {
	AbonnementRepository abonnementRepo;
	public AbonnementController(AbonnementRepository repo) {
		this.abonnementRepo=repo;
		// TODO Auto-generated constructor stub
	}
@GetMapping("/getAbonnementByIdMongo/{id}")
public ResponseEntity<Abonnement> getAbonnement( @PathVariable String id) {
	if(abonnementRepo.existsByIdMongo(id)) {
		Abonnement ab=abonnementRepo.findByIdMongo( id);
		return new ResponseEntity<Abonnement>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Abonnement>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getAbonnementById/{id}")
public ResponseEntity<Abonnement> getAbonnement( @PathVariable int id) {
	if(abonnementRepo.existsById(id)) {
		Abonnement ab=abonnementRepo.findById( id);
		return new ResponseEntity<Abonnement>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Abonnement>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getAllAbonnements")
public ResponseEntity<List<Abonnement>> getAbonnement( ) {
	List<Abonnement> lab=abonnementRepo.findAll();
	return new ResponseEntity<List<Abonnement>>(lab,HttpStatus.OK);
}
@PostMapping("/addAbonnement")
public ResponseEntity<Abonnement> addAbonnement(@RequestBody Abonnement ab) {
	if(!abonnementRepo.existsById(ab.getId())) {
		abonnementRepo.save(ab);
		return new ResponseEntity<Abonnement>(ab,HttpStatus.CREATED);
	}
	return new ResponseEntity<Abonnement>(HttpStatus.CONFLICT);
}
@PutMapping("/updateAbonnement/{id}")
public ResponseEntity<Abonnement> updateAbonnement(@PathVariable int id,@RequestBody Abonnement ab) {
	if(abonnementRepo.existsById(id)) {
		abonnementRepo.save(ab);
		return new ResponseEntity<Abonnement>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Abonnement>(HttpStatus.NOT_FOUND);
}
@DeleteMapping("/deleteAbonnement/{id}")
public ResponseEntity<Abonnement> deleteAbonnement(@PathVariable int id) {
	if(abonnementRepo.existsById(id)) {
		Abonnement ab=abonnementRepo.deleteById(id);
		return new ResponseEntity<Abonnement>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Abonnement>(HttpStatus.NOT_FOUND);
}


}

