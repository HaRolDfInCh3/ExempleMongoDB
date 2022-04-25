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

import com.test.microservices.pojos.Departement;
import com.test.microservices.repositories.DepartementsRepository;
@RestController
public class DepartementController {
	DepartementsRepository departementRepo;
	public DepartementController(DepartementsRepository repo) {
		this.departementRepo=repo;
		// TODO Auto-generated constructor stub
	}
@GetMapping("/getDepartementByIdMongo/{id}")
public ResponseEntity<Departement> getDepartement( @PathVariable String id) {
	if(departementRepo.existsByIdMongo(id)) {
		Departement ab=departementRepo.findByIdMongo( id);
		return new ResponseEntity<Departement>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Departement>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getDepartementById/{id}")
public ResponseEntity<Departement> getDepartement( @PathVariable int id) {
	if(departementRepo.existsById(id)) {
		Departement ab=departementRepo.findById( id);
		return new ResponseEntity<Departement>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Departement>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getAllDepartements")
public ResponseEntity<List<Departement>> getDepartement( ) {
	List<Departement> lab=departementRepo.findAll();
	return new ResponseEntity<List<Departement>>(lab,HttpStatus.OK);
}
@PostMapping("/addDepartement")
public ResponseEntity<Departement> addDepartement(@RequestBody Departement ab) {
	if(!departementRepo.existsById(ab.getId())) {
		departementRepo.save(ab);
		return new ResponseEntity<Departement>(ab,HttpStatus.CREATED);
	}
	return new ResponseEntity<Departement>(HttpStatus.CONFLICT);
}
@PutMapping("/updateDepartement/{id}")
public ResponseEntity<Departement> updateDepartement(@PathVariable int id,@RequestBody Departement ab) {
	if(departementRepo.existsById(id)) {
		departementRepo.save(ab);
		return new ResponseEntity<Departement>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Departement>(HttpStatus.NOT_FOUND);
}
@DeleteMapping("/deleteDepartement/{id}")
public ResponseEntity<Departement> deleteDepartement(@PathVariable int id) {
	if(departementRepo.existsById(id)) {
		Departement ab=departementRepo.deleteById(id);
		return new ResponseEntity<Departement>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Departement>(HttpStatus.NOT_FOUND);
}


}
