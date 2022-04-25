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

import com.test.microservices.pojos.Technique;
import com.test.microservices.repositories.TechniqueRepository;

@RestController
public class TechniqueController {
	TechniqueRepository techniqueRepo;
	public TechniqueController(TechniqueRepository repo) {
		this.techniqueRepo=repo;
		// TODO Auto-generated constructor stub
	}
@GetMapping("/getTechniqueByIdMongo/{id}")
public ResponseEntity<Technique> getTechnique( @PathVariable String id) {
	if(techniqueRepo.existsByIdMongo(id)) {
		Technique ab=techniqueRepo.findByIdMongo( id);
		return new ResponseEntity<Technique>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Technique>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getTechniqueById/{id}")
public ResponseEntity<Technique> getTechnique( @PathVariable int id) {
	if(techniqueRepo.existsById(id)) {
		Technique ab=techniqueRepo.findById( id);
		return new ResponseEntity<Technique>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Technique>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getAllTechniques")
public ResponseEntity<List<Technique>> getTechnique( ) {
	List<Technique> lab=techniqueRepo.findAll();
	return new ResponseEntity<List<Technique>>(lab,HttpStatus.OK);
}
@PostMapping("/addTechnique")
public ResponseEntity<Technique> addTechnique(@RequestBody Technique ab) {
	if(!techniqueRepo.existsById(ab.getId())) {
		techniqueRepo.save(ab);
		return new ResponseEntity<Technique>(ab,HttpStatus.CREATED);
	}
	return new ResponseEntity<Technique>(HttpStatus.CONFLICT);
}
@PutMapping("/updateTechnique/{id}")
public ResponseEntity<Technique> updateTechnique(@PathVariable int id,@RequestBody Technique ab) {
	if(techniqueRepo.existsById(id)) {
		techniqueRepo.save(ab);
		return new ResponseEntity<Technique>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Technique>(HttpStatus.NOT_FOUND);
}
@DeleteMapping("/deleteTechnique/{id}")
public ResponseEntity<Technique> deleteTechnique(@PathVariable int id) {
	if(techniqueRepo.existsById(id)) {
		Technique ab=techniqueRepo.deleteById(id);
		return new ResponseEntity<Technique>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Technique>(HttpStatus.NOT_FOUND);
}


}
