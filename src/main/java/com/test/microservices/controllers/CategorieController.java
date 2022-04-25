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

import com.test.microservices.pojos.Categorie;
import com.test.microservices.repositories.CategorieRepository;
@RestController
public class CategorieController {
	CategorieRepository categorieRepo;
	public CategorieController(CategorieRepository repo) {
		this.categorieRepo=repo;
		// TODO Auto-generated constructor stub
	}
@GetMapping("/getCategorieByIdMongo/{id}")
public ResponseEntity<Categorie> getCategorie( @PathVariable String id) {
	if(categorieRepo.existsByIdMongo(id)) {
		Categorie ab=categorieRepo.findByIdMongo( id);
		return new ResponseEntity<Categorie>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Categorie>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getCategorieById/{id}")
public ResponseEntity<Categorie> getCategorie( @PathVariable int id) {
	if(categorieRepo.existsById(id)) {
		Categorie ab=categorieRepo.findById( id);
		return new ResponseEntity<Categorie>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Categorie>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getAllCategories")
public ResponseEntity<List<Categorie>> getCategorie( ) {
	List<Categorie> lab=categorieRepo.findAll();
	return new ResponseEntity<List<Categorie>>(lab,HttpStatus.OK);
}
@PostMapping("/addCategorie")
public ResponseEntity<Categorie> addCategorie(@RequestBody Categorie ab) {
	if(!categorieRepo.existsById(ab.getId())) {
		categorieRepo.save(ab);
		return new ResponseEntity<Categorie>(ab,HttpStatus.CREATED);
	}
	return new ResponseEntity<Categorie>(HttpStatus.CONFLICT);
}
@PutMapping("/updateCategorie/{id}")
public ResponseEntity<Categorie> updateCategorie(@PathVariable int id,@RequestBody Categorie ab) {
	if(categorieRepo.existsById(id)) {
		categorieRepo.save(ab);
		return new ResponseEntity<Categorie>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Categorie>(HttpStatus.NOT_FOUND);
}
@DeleteMapping("/deleteCategorie/{id}")
public ResponseEntity<Categorie> deleteCategorie(@PathVariable int id) {
	if(categorieRepo.existsById(id)) {
		Categorie ab=categorieRepo.deleteById(id);
		return new ResponseEntity<Categorie>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Categorie>(HttpStatus.NOT_FOUND);
}


}
