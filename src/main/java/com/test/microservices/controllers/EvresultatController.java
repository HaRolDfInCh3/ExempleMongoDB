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

import com.test.microservices.pojos.Evresultat;
import com.test.microservices.repositories.EvresultatsRepository;

@RestController
public class EvresultatController {
	EvresultatsRepository evresultatRepo;
	public EvresultatController(EvresultatsRepository repo) {
		this.evresultatRepo=repo;
		// TODO Auto-generated constructor stub
	}
@GetMapping("/getEvresultatByIdMongo/{id}")
public ResponseEntity<Evresultat> getEvresultat( @PathVariable String id) {
	if(evresultatRepo.existsByIdMongo(id)) {
		Evresultat ab=evresultatRepo.findByIdMongo( id);
		return new ResponseEntity<Evresultat>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Evresultat>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getEvresultatById/{id}")
public ResponseEntity<Evresultat> getEvresultat( @PathVariable int id) {
	if(evresultatRepo.existsById(id)) {
		Evresultat ab=evresultatRepo.findById( id);
		return new ResponseEntity<Evresultat>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Evresultat>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getAllEvresultats")
public ResponseEntity<List<Evresultat>> getEvresultat( ) {
	List<Evresultat> lab=evresultatRepo.findAll();
	return new ResponseEntity<List<Evresultat>>(lab,HttpStatus.OK);
}
@PostMapping("/addEvresultat")
public ResponseEntity<Evresultat> addEvresultat(@RequestBody Evresultat ab) {
	if(!evresultatRepo.existsById(ab.getId())) {
		evresultatRepo.save(ab);
		return new ResponseEntity<Evresultat>(ab,HttpStatus.CREATED);
	}
	return new ResponseEntity<Evresultat>(HttpStatus.CONFLICT);
}
@PutMapping("/updateEvresultat/{id}")
public ResponseEntity<Evresultat> updateEvresultat(@PathVariable int id,@RequestBody Evresultat ab) {
	if(evresultatRepo.existsById(id)) {
		evresultatRepo.save(ab);
		return new ResponseEntity<Evresultat>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Evresultat>(HttpStatus.NOT_FOUND);
}
@DeleteMapping("/deleteEvresultat/{id}")
public ResponseEntity<Evresultat> deleteEvresultat(@PathVariable int id) {
	if(evresultatRepo.existsById(id)) {
		Evresultat ab=evresultatRepo.deleteById(id);
		return new ResponseEntity<Evresultat>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Evresultat>(HttpStatus.NOT_FOUND);
}


}
