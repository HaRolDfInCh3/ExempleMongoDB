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

import com.test.microservices.pojos.Evenementimportantdirect;
import com.test.microservices.repositories.EvenementimportantdirectRepository;
@RestController
public class EvenementimportantdirectController {
	EvenementimportantdirectRepository evenementimportantdirectRepo;
	public EvenementimportantdirectController(EvenementimportantdirectRepository repo) {
		this.evenementimportantdirectRepo=repo;
		// TODO Auto-generated constructor stub
	}
@GetMapping("/getEvenementimportantdirectByIdMongo/{id}")
public ResponseEntity<Evenementimportantdirect> getEvenementimportantdirect( @PathVariable String id) {
	if(evenementimportantdirectRepo.existsByIdMongo(id)) {
		Evenementimportantdirect ab=evenementimportantdirectRepo.findByIdMongo( id);
		return new ResponseEntity<Evenementimportantdirect>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Evenementimportantdirect>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getEvenementimportantdirectById/{id}")
public ResponseEntity<Evenementimportantdirect> getEvenementimportantdirect( @PathVariable int id) {
	if(evenementimportantdirectRepo.existsById(id)) {
		Evenementimportantdirect ab=evenementimportantdirectRepo.findById( id);
		return new ResponseEntity<Evenementimportantdirect>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Evenementimportantdirect>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getAllEvenementimportantdirects")
public ResponseEntity<List<Evenementimportantdirect>> getEvenementimportantdirect( ) {
	List<Evenementimportantdirect> lab=evenementimportantdirectRepo.findAll();
	return new ResponseEntity<List<Evenementimportantdirect>>(lab,HttpStatus.OK);
}
@PostMapping("/addEvenementimportantdirect")
public ResponseEntity<Evenementimportantdirect> addEvenementimportantdirect(@RequestBody Evenementimportantdirect ab) {
	if(!evenementimportantdirectRepo.existsById(ab.getId())) {
		evenementimportantdirectRepo.save(ab);
		return new ResponseEntity<Evenementimportantdirect>(ab,HttpStatus.CREATED);
	}
	return new ResponseEntity<Evenementimportantdirect>(HttpStatus.CONFLICT);
}
@PutMapping("/updateEvenementimportantdirect/{id}")
public ResponseEntity<Evenementimportantdirect> updateEvenementimportantdirect(@PathVariable int id,@RequestBody Evenementimportantdirect ab) {
	if(evenementimportantdirectRepo.existsById(id)) {
		evenementimportantdirectRepo.save(ab);
		return new ResponseEntity<Evenementimportantdirect>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Evenementimportantdirect>(HttpStatus.NOT_FOUND);
}
@DeleteMapping("/deleteEvenementimportantdirect/{id}")
public ResponseEntity<Evenementimportantdirect> deleteEvenementimportantdirect(@PathVariable int id) {
	if(evenementimportantdirectRepo.existsById(id)) {
		Evenementimportantdirect ab=evenementimportantdirectRepo.deleteById(id);
		return new ResponseEntity<Evenementimportantdirect>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Evenementimportantdirect>(HttpStatus.NOT_FOUND);
}


}
