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

import com.test.microservices.pojos.Bannieres_par_taille;
import com.test.microservices.repositories.Bannieres_par_tailleRepository;

@RestController
public class Bannieres_par_tailleController {
	Bannieres_par_tailleRepository bannieres_par_tailleRepo;
	public Bannieres_par_tailleController(Bannieres_par_tailleRepository repo) {
		this.bannieres_par_tailleRepo=repo;
		// TODO Auto-generated constructor stub
	}
@GetMapping("/getBannieres_par_tailleByIdMongo/{id}")
public ResponseEntity<Bannieres_par_taille> getBannieres_par_taille( @PathVariable String id) {
	if(bannieres_par_tailleRepo.existsByIdMongo(id)) {
		Bannieres_par_taille ab=bannieres_par_tailleRepo.findByIdMongo( id);
		return new ResponseEntity<Bannieres_par_taille>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Bannieres_par_taille>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getBannieres_par_tailleById/{id}")
public ResponseEntity<Bannieres_par_taille> getBannieres_par_taille( @PathVariable int id) {
	if(bannieres_par_tailleRepo.existsById(id)) {
		Bannieres_par_taille ab=bannieres_par_tailleRepo.findById( id);
		return new ResponseEntity<Bannieres_par_taille>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Bannieres_par_taille>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getBannieres_par_taille/{taille}")
public ResponseEntity<List<Bannieres_par_taille>> rechercheBannieres_par_taille( @PathVariable String taille) {
	
		List<Bannieres_par_taille> lab=bannieres_par_tailleRepo.rechercheParTaille(taille);
		return new ResponseEntity<List<Bannieres_par_taille>>(lab,HttpStatus.OK);
	
}
@GetMapping("/getAllBannieres_par_tailles")
public ResponseEntity<List<Bannieres_par_taille>> getBannieres_par_taille( ) {
	List<Bannieres_par_taille> lab=bannieres_par_tailleRepo.findAll();
	return new ResponseEntity<List<Bannieres_par_taille>>(lab,HttpStatus.OK);
}
@PostMapping("/addBannieres_par_taille")
public ResponseEntity<Bannieres_par_taille> addBannieres_par_taille(@RequestBody Bannieres_par_taille ab) {
	if(!bannieres_par_tailleRepo.existsById(ab.getId())) {
		bannieres_par_tailleRepo.save(ab);
		return new ResponseEntity<Bannieres_par_taille>(ab,HttpStatus.CREATED);
	}
	return new ResponseEntity<Bannieres_par_taille>(HttpStatus.CONFLICT);
}
@PutMapping("/updateBannieres_par_taille/{id}")
public ResponseEntity<Bannieres_par_taille> updateBannieres_par_taille(@PathVariable int id,@RequestBody Bannieres_par_taille ab) {
	if(bannieres_par_tailleRepo.existsById(id)) {
		bannieres_par_tailleRepo.save(ab);
		return new ResponseEntity<Bannieres_par_taille>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Bannieres_par_taille>(HttpStatus.NOT_FOUND);
}
@DeleteMapping("/deleteBannieres_par_taille/{id}")
public ResponseEntity<Bannieres_par_taille> deleteBannieres_par_taille(@PathVariable int id) {
	if(bannieres_par_tailleRepo.existsById(id)) {
		Bannieres_par_taille ab=bannieres_par_tailleRepo.deleteById(id);
		return new ResponseEntity<Bannieres_par_taille>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Bannieres_par_taille>(HttpStatus.NOT_FOUND);
}


}
