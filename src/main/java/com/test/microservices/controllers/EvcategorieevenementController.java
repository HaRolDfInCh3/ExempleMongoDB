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

import com.test.microservices.pojos.Evcategorieevenement;
import com.test.microservices.repositories.EvcategorieevenementRepository;
@RestController
public class EvcategorieevenementController {
	EvcategorieevenementRepository evcategorieevenementRepo;
	public EvcategorieevenementController(EvcategorieevenementRepository repo) {
		this.evcategorieevenementRepo=repo;
		// TODO Auto-generated constructor stub
	}
@GetMapping("/getEvcategorieevenementByIdMongo/{id}")
public ResponseEntity<Evcategorieevenement> getEvcategorieevenement( @PathVariable String id) {
	if(evcategorieevenementRepo.existsByIdMongo(id)) {
		Evcategorieevenement ab=evcategorieevenementRepo.findByIdMongo( id);
		return new ResponseEntity<Evcategorieevenement>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Evcategorieevenement>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getEvcategorieevenementById/{id}")
public ResponseEntity<Evcategorieevenement> getEvcategorieevenement( @PathVariable int id) {
	if(evcategorieevenementRepo.existsById(id)) {
		Evcategorieevenement ab=evcategorieevenementRepo.findById( id);
		return new ResponseEntity<Evcategorieevenement>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Evcategorieevenement>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getAllEvcategorieevenements")
public ResponseEntity<List<Evcategorieevenement>> getEvcategorieevenement( ) {
	List<Evcategorieevenement> lab=evcategorieevenementRepo.findAll();
	return new ResponseEntity<List<Evcategorieevenement>>(lab,HttpStatus.OK);
}
@PostMapping("/addEvcategorieevenement")
public ResponseEntity<Evcategorieevenement> addEvcategorieevenement(@RequestBody Evcategorieevenement ab) {
	if(!evcategorieevenementRepo.existsById(ab.getId())) {
		evcategorieevenementRepo.save(ab);
		return new ResponseEntity<Evcategorieevenement>(ab,HttpStatus.CREATED);
	}
	return new ResponseEntity<Evcategorieevenement>(HttpStatus.CONFLICT);
}
@PutMapping("/updateEvcategorieevenement/{id}")
public ResponseEntity<Evcategorieevenement> updateEvcategorieevenement(@PathVariable int id,@RequestBody Evcategorieevenement ab) {
	if(evcategorieevenementRepo.existsById(id)) {
		evcategorieevenementRepo.save(ab);
		return new ResponseEntity<Evcategorieevenement>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Evcategorieevenement>(HttpStatus.NOT_FOUND);
}
@DeleteMapping("/deleteEvcategorieevenement/{id}")
public ResponseEntity<Evcategorieevenement> deleteEvcategorieevenement(@PathVariable int id) {
	if(evcategorieevenementRepo.existsById(id)) {
		Evcategorieevenement ab=evcategorieevenementRepo.deleteById(id);
		return new ResponseEntity<Evcategorieevenement>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Evcategorieevenement>(HttpStatus.NOT_FOUND);
}


}
