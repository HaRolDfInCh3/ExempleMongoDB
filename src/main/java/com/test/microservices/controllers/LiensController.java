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

import com.test.microservices.pojos.Liens;
import com.test.microservices.repositories.LiensRepository;

@RestController
public class LiensController {
	LiensRepository liensRepo;
	public LiensController(LiensRepository repo) {
		this.liensRepo=repo;
		// TODO Auto-generated constructor stub
	}
@GetMapping("/getLiensByIdMongo/{id}")
public ResponseEntity<Liens> getLiens( @PathVariable String id) {
	if(liensRepo.existsByIdMongo(id)) {
		Liens ab=liensRepo.findByIdMongo( id);
		return new ResponseEntity<Liens>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Liens>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getLiensById/{id}")
public ResponseEntity<Liens> getLiens( @PathVariable int id) {
	if(liensRepo.existsById(id)) {
		Liens ab=liensRepo.findById( id);
		return new ResponseEntity<Liens>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Liens>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getAllLienss")
public ResponseEntity<List<Liens>> getLiens( ) {
	List<Liens> lab=liensRepo.findAll();
	return new ResponseEntity<List<Liens>>(lab,HttpStatus.OK);
}
@PostMapping("/addLiens")
public ResponseEntity<Liens> addLiens(@RequestBody Liens ab) {
	if(!liensRepo.existsById(ab.getId())) {
		liensRepo.save(ab);
		return new ResponseEntity<Liens>(ab,HttpStatus.CREATED);
	}
	return new ResponseEntity<Liens>(HttpStatus.CONFLICT);
}
@PutMapping("/updateLiens/{id}")
public ResponseEntity<Liens> updateLiens(@PathVariable int id,@RequestBody Liens ab) {
	if(liensRepo.existsById(id)) {
		liensRepo.save(ab);
		return new ResponseEntity<Liens>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Liens>(HttpStatus.NOT_FOUND);
}
@DeleteMapping("/deleteLiens/{id}")
public ResponseEntity<Liens> deleteLiens(@PathVariable int id) {
	if(liensRepo.existsById(id)) {
		Liens ab=liensRepo.deleteById(id);
		return new ResponseEntity<Liens>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Liens>(HttpStatus.NOT_FOUND);
}


}
