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

import com.test.microservices.pojos.Liens2;
import com.test.microservices.repositories.Liens2Repository;

@RestController
public class Lien2Controller {
	Liens2Repository liens2Repo;
	public Lien2Controller(Liens2Repository repo) {
		this.liens2Repo=repo;
		// TODO Auto-generated constructor stub
	}
@GetMapping("/getLiens2ByIdMongo/{id}")
public ResponseEntity<Liens2> getLiens2( @PathVariable String id) {
	if(liens2Repo.existsByIdMongo(id)) {
		Liens2 ab=liens2Repo.findByIdMongo( id);
		return new ResponseEntity<Liens2>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Liens2>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getLiens2ById/{id}")
public ResponseEntity<Liens2> getLiens2( @PathVariable int id) {
	if(liens2Repo.existsById(id)) {
		Liens2 ab=liens2Repo.findById( id);
		return new ResponseEntity<Liens2>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Liens2>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getAllLiens2s")
public ResponseEntity<List<Liens2>> getLiens2( ) {
	List<Liens2> lab=liens2Repo.findAll();
	return new ResponseEntity<List<Liens2>>(lab,HttpStatus.OK);
}
@PostMapping("/addLiens2")
public ResponseEntity<Liens2> addLiens2(@RequestBody Liens2 ab) {
	if(!liens2Repo.existsById(ab.getId())) {
		liens2Repo.save(ab);
		return new ResponseEntity<Liens2>(ab,HttpStatus.CREATED);
	}
	return new ResponseEntity<Liens2>(HttpStatus.CONFLICT);
}
@PutMapping("/updateLiens2/{id}")
public ResponseEntity<Liens2> updateLiens2(@PathVariable int id,@RequestBody Liens2 ab) {
	if(liens2Repo.existsById(id)) {
		liens2Repo.save(ab);
		return new ResponseEntity<Liens2>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Liens2>(HttpStatus.NOT_FOUND);
}
@DeleteMapping("/deleteLiens2/{id}")
public ResponseEntity<Liens2> deleteLiens2(@PathVariable int id) {
	if(liens2Repo.existsById(id)) {
		Liens2 ab=liens2Repo.deleteById(id);
		return new ResponseEntity<Liens2>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Liens2>(HttpStatus.NOT_FOUND);
}


}
