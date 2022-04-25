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

import com.test.microservices.pojos.Sous_categorie;
import com.test.microservices.repositories.Sous_categorieRepository;

@RestController
public class SousCategorieController {
	Sous_categorieRepository souscategorieRepo;
	public SousCategorieController(Sous_categorieRepository repo) {
		this.souscategorieRepo=repo;
		// TODO Auto-generated constructor stub
	}
@GetMapping("/getSous_categorieByIdMongo/{id}")
public ResponseEntity<Sous_categorie> getSous_categorie( @PathVariable String id) {
	if(souscategorieRepo.existsByIdMongo(id)) {
		Sous_categorie ab=souscategorieRepo.findByIdMongo( id);
		return new ResponseEntity<Sous_categorie>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Sous_categorie>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getSous_categorieById/{id}")
public ResponseEntity<Sous_categorie> getSous_categorie( @PathVariable int id) {
	if(souscategorieRepo.existsById(id)) {
		Sous_categorie ab=souscategorieRepo.findById( id);
		return new ResponseEntity<Sous_categorie>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Sous_categorie>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getAllSous_categories")
public ResponseEntity<List<Sous_categorie>> getSous_categorie( ) {
	List<Sous_categorie> lab=souscategorieRepo.findAll();
	return new ResponseEntity<List<Sous_categorie>>(lab,HttpStatus.OK);
}
@PostMapping("/addSous_categorie")
public ResponseEntity<Sous_categorie> addSous_categorie(@RequestBody Sous_categorie ab) {
	if(!souscategorieRepo.existsById(ab.getId())) {
		souscategorieRepo.save(ab);
		return new ResponseEntity<Sous_categorie>(ab,HttpStatus.CREATED);
	}
	return new ResponseEntity<Sous_categorie>(HttpStatus.CONFLICT);
}
@PutMapping("/updateSous_categorie/{id}")
public ResponseEntity<Sous_categorie> updateSous_categorie(@PathVariable int id,@RequestBody Sous_categorie ab) {
	if(souscategorieRepo.existsById(id)) {
		souscategorieRepo.save(ab);
		return new ResponseEntity<Sous_categorie>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Sous_categorie>(HttpStatus.NOT_FOUND);
}
@DeleteMapping("/deleteSous_categorie/{id}")
public ResponseEntity<Sous_categorie> deleteSous_categorie(@PathVariable int id) {
	if(souscategorieRepo.existsById(id)) {
		Sous_categorie ab=souscategorieRepo.deleteById(id);
		return new ResponseEntity<Sous_categorie>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Sous_categorie>(HttpStatus.NOT_FOUND);
}


}
