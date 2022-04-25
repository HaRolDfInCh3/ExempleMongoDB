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

import com.test.microservices.pojos.Annonce;
import com.test.microservices.repositories.AnnonceRepository;

@RestController
public class AnnonceController {
	AnnonceRepository annonceRepo;
	public AnnonceController(AnnonceRepository repo) {
		this.annonceRepo=repo;
		// TODO Auto-generated constructor stub
	}
@GetMapping("/getAnnonceByIdMongo/{id}")
public ResponseEntity<Annonce> getAnnonce( @PathVariable String id) {
	if(annonceRepo.existsByIdMongo(id)) {
		Annonce ab=annonceRepo.findByIdMongo( id);
		return new ResponseEntity<Annonce>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Annonce>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getAnnonceById/{id}")
public ResponseEntity<Annonce> getAnnonce( @PathVariable int id) {
	if(annonceRepo.existsById(id)) {
		Annonce ab=annonceRepo.findById( id);
		return new ResponseEntity<Annonce>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Annonce>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getAllAnnonces")
public ResponseEntity<List<Annonce>> getAnnonce( ) {
	List<Annonce> lab=annonceRepo.findAll();
	return new ResponseEntity<List<Annonce>>(lab,HttpStatus.OK);
}
@PostMapping("/addAnnonce")
public ResponseEntity<Annonce> addAnnonce(@RequestBody Annonce ab) {
	if(!annonceRepo.existsById(ab.getId())) {
		annonceRepo.save(ab);
		return new ResponseEntity<Annonce>(ab,HttpStatus.CREATED);
	}
	return new ResponseEntity<Annonce>(HttpStatus.CONFLICT);
}
@PutMapping("/updateAnnonce/{id}")
public ResponseEntity<Annonce> updateAnnonce(@PathVariable int id,@RequestBody Annonce ab) {
	if(annonceRepo.existsById(id)) {
		annonceRepo.save(ab);
		return new ResponseEntity<Annonce>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Annonce>(HttpStatus.NOT_FOUND);
}
@DeleteMapping("/deleteAnnonce/{id}")
public ResponseEntity<Annonce> deleteAnnonce(@PathVariable int id) {
	if(annonceRepo.existsById(id)) {
		Annonce ab=annonceRepo.deleteById(id);
		return new ResponseEntity<Annonce>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Annonce>(HttpStatus.NOT_FOUND);
}

}
