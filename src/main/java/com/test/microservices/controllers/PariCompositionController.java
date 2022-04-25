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

import com.test.microservices.pojos.Pari_composition;
import com.test.microservices.repositories.Pari_compositionRepository;

@RestController
public class PariCompositionController {
	Pari_compositionRepository pcRepo;
	public PariCompositionController(Pari_compositionRepository repo) {
		this.pcRepo=repo;
		// TODO Auto-generated constructor stub
	}
@GetMapping("/getPari_compositionByIdMongo/{id}")
public ResponseEntity<Pari_composition> getPari_composition( @PathVariable String id) {
	if(pcRepo.existsByIdMongo(id)) {
		Pari_composition ab=pcRepo.findByIdMongo( id);
		return new ResponseEntity<Pari_composition>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Pari_composition>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getPari_compositionById/{id}")
public ResponseEntity<Pari_composition> getPari_composition( @PathVariable int id) {
	if(pcRepo.existsById(id)) {
		Pari_composition ab=pcRepo.findById( id);
		return new ResponseEntity<Pari_composition>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Pari_composition>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getAllPari_compositions")
public ResponseEntity<List<Pari_composition>> getPari_composition( ) {
	List<Pari_composition> lab=pcRepo.findAll();
	return new ResponseEntity<List<Pari_composition>>(lab,HttpStatus.OK);
}
@PostMapping("/addPari_composition")
public ResponseEntity<Pari_composition> addPari_composition(@RequestBody Pari_composition ab) {
	if(!pcRepo.existsById(ab.getId())) {
		pcRepo.save(ab);
		return new ResponseEntity<Pari_composition>(ab,HttpStatus.CREATED);
	}
	return new ResponseEntity<Pari_composition>(HttpStatus.CONFLICT);
}
@PutMapping("/updatePari_composition/{id}")
public ResponseEntity<Pari_composition> updatePari_composition(@PathVariable int id,@RequestBody Pari_composition ab) {
	if(pcRepo.existsById(id)) {
		pcRepo.save(ab);
		return new ResponseEntity<Pari_composition>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Pari_composition>(HttpStatus.NOT_FOUND);
}
@DeleteMapping("/deletePari_composition/{id}")
public ResponseEntity<Pari_composition> deletePari_composition(@PathVariable int id) {
	if(pcRepo.existsById(id)) {
		Pari_composition ab=pcRepo.deleteById(id);
		return new ResponseEntity<Pari_composition>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Pari_composition>(HttpStatus.NOT_FOUND);
}


}
