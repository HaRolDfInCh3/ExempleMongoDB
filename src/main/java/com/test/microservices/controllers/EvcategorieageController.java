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

import com.test.microservices.pojos.Evcategorieage;
import com.test.microservices.repositories.EvcategorieageRepository;

@RestController
public class EvcategorieageController {
	EvcategorieageRepository evcategorieageRepo;
	public EvcategorieageController(EvcategorieageRepository repo) {
		this.evcategorieageRepo=repo;
		// TODO Auto-generated constructor stub
	}
@GetMapping("/getEvcategorieageByIdMongo/{id}")
public ResponseEntity<Evcategorieage> getEvcategorieage( @PathVariable String id) {
	if(evcategorieageRepo.existsByIdMongo(id)) {
		Evcategorieage ab=evcategorieageRepo.findByIdMongo( id);
		return new ResponseEntity<Evcategorieage>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Evcategorieage>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getEvcategorieageById/{id}")
public ResponseEntity<Evcategorieage> getEvcategorieage( @PathVariable int id) {
	if(evcategorieageRepo.existsById(id)) {
		Evcategorieage ab=evcategorieageRepo.findById( id);
		return new ResponseEntity<Evcategorieage>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Evcategorieage>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getAllEvcategorieages")
public ResponseEntity<List<Evcategorieage>> getEvcategorieage( ) {
	List<Evcategorieage> lab=evcategorieageRepo.findAll();
	return new ResponseEntity<List<Evcategorieage>>(lab,HttpStatus.OK);
}
@PostMapping("/addEvcategorieage")
public ResponseEntity<Evcategorieage> addEvcategorieage(@RequestBody Evcategorieage ab) {
	if(!evcategorieageRepo.existsById(ab.getId())) {
		evcategorieageRepo.save(ab);
		return new ResponseEntity<Evcategorieage>(ab,HttpStatus.CREATED);
	}
	return new ResponseEntity<Evcategorieage>(HttpStatus.CONFLICT);
}
@PutMapping("/updateEvcategorieage/{id}")
public ResponseEntity<Evcategorieage> updateEvcategorieage(@PathVariable int id,@RequestBody Evcategorieage ab) {
	if(evcategorieageRepo.existsById(id)) {
		evcategorieageRepo.save(ab);
		return new ResponseEntity<Evcategorieage>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Evcategorieage>(HttpStatus.NOT_FOUND);
}
@DeleteMapping("/deleteEvcategorieage/{id}")
public ResponseEntity<Evcategorieage> deleteEvcategorieage(@PathVariable int id) {
	if(evcategorieageRepo.existsById(id)) {
		Evcategorieage ab=evcategorieageRepo.deleteById(id);
		return new ResponseEntity<Evcategorieage>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Evcategorieage>(HttpStatus.NOT_FOUND);
}


}
