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

import com.test.microservices.pojos.Newscategorie;
import com.test.microservices.repositories.NewscategorieRepository;

@RestController
public class NewsCategorieController {
	NewscategorieRepository newscategorieRepo;
	public NewsCategorieController(NewscategorieRepository repo) {
		this.newscategorieRepo=repo;
		// TODO Auto-generated constructor stub
	}
@GetMapping("/getNewscategorieByIdMongo/{id}")
public ResponseEntity<Newscategorie> getNewscategorie( @PathVariable String id) {
	if(newscategorieRepo.existsByIdMongo(id)) {
		Newscategorie ab=newscategorieRepo.findByIdMongo( id);
		return new ResponseEntity<Newscategorie>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Newscategorie>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getNewscategorieById/{id}")
public ResponseEntity<Newscategorie> getNewscategorie( @PathVariable int id) {
	if(newscategorieRepo.existsById(id)) {
		Newscategorie ab=newscategorieRepo.findById( id);
		return new ResponseEntity<Newscategorie>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Newscategorie>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getAllNewscategories")
public ResponseEntity<List<Newscategorie>> getNewscategorie( ) {
	List<Newscategorie> lab=newscategorieRepo.findAll();
	return new ResponseEntity<List<Newscategorie>>(lab,HttpStatus.OK);
}
@PostMapping("/addNewscategorie")
public ResponseEntity<Newscategorie> addNewscategorie(@RequestBody Newscategorie ab) {
	if(!newscategorieRepo.existsById(ab.getId())) {
		newscategorieRepo.save(ab);
		return new ResponseEntity<Newscategorie>(ab,HttpStatus.CREATED);
	}
	return new ResponseEntity<Newscategorie>(HttpStatus.CONFLICT);
}
@PutMapping("/updateNewscategorie/{id}")
public ResponseEntity<Newscategorie> updateNewscategorie(@PathVariable int id,@RequestBody Newscategorie ab) {
	if(newscategorieRepo.existsById(id)) {
		newscategorieRepo.save(ab);
		return new ResponseEntity<Newscategorie>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Newscategorie>(HttpStatus.NOT_FOUND);
}
@DeleteMapping("/deleteNewscategorie/{id}")
public ResponseEntity<Newscategorie> deleteNewscategorie(@PathVariable int id) {
	if(newscategorieRepo.existsById(id)) {
		Newscategorie ab=newscategorieRepo.deleteById(id);
		return new ResponseEntity<Newscategorie>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Newscategorie>(HttpStatus.NOT_FOUND);
}


}
