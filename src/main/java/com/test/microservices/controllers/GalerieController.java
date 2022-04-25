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

import com.test.microservices.pojos.Galerie;
import com.test.microservices.repositories.GaleriesRepository;
@RestController
public class GalerieController {
	GaleriesRepository galerieRepo;
	public GalerieController(GaleriesRepository repo) {
		this.galerieRepo=repo;
		// TODO Auto-generated constructor stub
	}
@GetMapping("/getGalerieByIdMongo/{id}")
public ResponseEntity<Galerie> getGalerie( @PathVariable String id) {
	if(galerieRepo.existsByIdMongo(id)) {
		Galerie ab=galerieRepo.findByIdMongo( id);
		return new ResponseEntity<Galerie>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Galerie>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getGalerieById/{id}")
public ResponseEntity<Galerie> getGalerie( @PathVariable int id) {
	if(galerieRepo.existsById(id)) {
		Galerie ab=galerieRepo.findById( id);
		return new ResponseEntity<Galerie>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Galerie>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getAllGaleries")
public ResponseEntity<List<Galerie>> getGalerie( ) {
	List<Galerie> lab=galerieRepo.findAll();
	return new ResponseEntity<List<Galerie>>(lab,HttpStatus.OK);
}
@PostMapping("/addGalerie")
public ResponseEntity<Galerie> addGalerie(@RequestBody Galerie ab) {
	if(!galerieRepo.existsById(ab.getId())) {
		galerieRepo.save(ab);
		return new ResponseEntity<Galerie>(ab,HttpStatus.CREATED);
	}
	return new ResponseEntity<Galerie>(HttpStatus.CONFLICT);
}
@PutMapping("/updateGalerie/{id}")
public ResponseEntity<Galerie> updateGalerie(@PathVariable int id,@RequestBody Galerie ab) {
	if(galerieRepo.existsById(id)) {
		galerieRepo.save(ab);
		return new ResponseEntity<Galerie>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Galerie>(HttpStatus.NOT_FOUND);
}
@DeleteMapping("/deleteGalerie/{id}")
public ResponseEntity<Galerie> deleteGalerie(@PathVariable int id) {
	if(galerieRepo.existsById(id)) {
		Galerie ab=galerieRepo.deleteById(id);
		return new ResponseEntity<Galerie>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Galerie>(HttpStatus.NOT_FOUND);
}


}
