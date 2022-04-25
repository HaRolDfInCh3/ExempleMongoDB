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

import com.test.microservices.pojos.Entrainement;
import com.test.microservices.repositories.EntrainementRepository;
@RestController
public class EntrainementController {
	EntrainementRepository entrainementRepo;
	public EntrainementController(EntrainementRepository repo) {
		this.entrainementRepo=repo;
		// TODO Auto-generated constructor stub
	}
@GetMapping("/getEntrainementByIdMongo/{id}")
public ResponseEntity<Entrainement> getEntrainement( @PathVariable String id) {
	if(entrainementRepo.existsByIdMongo(id)) {
		Entrainement ab=entrainementRepo.findByIdMongo( id);
		return new ResponseEntity<Entrainement>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Entrainement>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getEntrainementById/{id}")
public ResponseEntity<Entrainement> getEntrainement( @PathVariable int id) {
	if(entrainementRepo.existsById(id)) {
		Entrainement ab=entrainementRepo.findById( id);
		return new ResponseEntity<Entrainement>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Entrainement>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getAllEntrainements")
public ResponseEntity<List<Entrainement>> getEntrainement( ) {
	List<Entrainement> lab=entrainementRepo.findAll();
	return new ResponseEntity<List<Entrainement>>(lab,HttpStatus.OK);
}
@PostMapping("/addEntrainement")
public ResponseEntity<Entrainement> addEntrainement(@RequestBody Entrainement ab) {
	if(!entrainementRepo.existsById(ab.getId())) {
		entrainementRepo.save(ab);
		return new ResponseEntity<Entrainement>(ab,HttpStatus.CREATED);
	}
	return new ResponseEntity<Entrainement>(HttpStatus.CONFLICT);
}
@PutMapping("/updateEntrainement/{id}")
public ResponseEntity<Entrainement> updateEntrainement(@PathVariable int id,@RequestBody Entrainement ab) {
	if(entrainementRepo.existsById(id)) {
		entrainementRepo.save(ab);
		return new ResponseEntity<Entrainement>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Entrainement>(HttpStatus.NOT_FOUND);
}
@DeleteMapping("/deleteEntrainement/{id}")
public ResponseEntity<Entrainement> deleteEntrainement(@PathVariable int id) {
	if(entrainementRepo.existsById(id)) {
		Entrainement ab=entrainementRepo.deleteById(id);
		return new ResponseEntity<Entrainement>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Entrainement>(HttpStatus.NOT_FOUND);
}


}
