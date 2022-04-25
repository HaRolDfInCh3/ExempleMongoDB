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

import com.test.microservices.pojos.Lienscategorie;
import com.test.microservices.repositories.LienscategorieRepository;

@RestController
public class LiensCategorieController {
		LienscategorieRepository abonnementRepo;
		public LiensCategorieController(LienscategorieRepository repo) {
			this.abonnementRepo=repo;
			// TODO Auto-generated constructor stub
		}
	@GetMapping("/getLienscategorieByIdMongo/{id}")
	public ResponseEntity<Lienscategorie> getLienscategorie( @PathVariable String id) {
		if(abonnementRepo.existsByIdMongo(id)) {
			Lienscategorie ab=abonnementRepo.findByIdMongo( id);
			return new ResponseEntity<Lienscategorie>(ab,HttpStatus.OK);
		}
		return new ResponseEntity<Lienscategorie>(HttpStatus.NOT_FOUND);
	}
	@GetMapping("/getLienscategorieById/{id}")
	public ResponseEntity<Lienscategorie> getLienscategorie( @PathVariable int id) {
		if(abonnementRepo.existsById(id)) {
			Lienscategorie ab=abonnementRepo.findById( id);
			return new ResponseEntity<Lienscategorie>(ab,HttpStatus.OK);
		}
		return new ResponseEntity<Lienscategorie>(HttpStatus.NOT_FOUND);
	}
	@GetMapping("/getAllLienscategories")
	public ResponseEntity<List<Lienscategorie>> getLienscategorie( ) {
		List<Lienscategorie> lab=abonnementRepo.findAll();
		return new ResponseEntity<List<Lienscategorie>>(lab,HttpStatus.OK);
	}
	@PostMapping("/addLienscategorie")
	public ResponseEntity<Lienscategorie> addLienscategorie(@RequestBody Lienscategorie ab) {
		if(!abonnementRepo.existsById(ab.getId())) {
			abonnementRepo.save(ab);
			return new ResponseEntity<Lienscategorie>(ab,HttpStatus.CREATED);
		}
		return new ResponseEntity<Lienscategorie>(HttpStatus.CONFLICT);
	}
	@PutMapping("/updateLienscategorie/{id}")
	public ResponseEntity<Lienscategorie> updateLienscategorie(@PathVariable int id,@RequestBody Lienscategorie ab) {
		if(abonnementRepo.existsById(id)) {
			abonnementRepo.save(ab);
			return new ResponseEntity<Lienscategorie>(ab,HttpStatus.OK);
		}
		return new ResponseEntity<Lienscategorie>(HttpStatus.NOT_FOUND);
	}
	@DeleteMapping("/deleteLienscategorie/{id}")
	public ResponseEntity<Lienscategorie> deleteLienscategorie(@PathVariable int id) {
		if(abonnementRepo.existsById(id)) {
			Lienscategorie ab=abonnementRepo.deleteById(id);
			return new ResponseEntity<Lienscategorie>(ab,HttpStatus.OK);
		}
		return new ResponseEntity<Lienscategorie>(HttpStatus.NOT_FOUND);
	}


	}
