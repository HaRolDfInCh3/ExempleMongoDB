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

import com.test.microservices.pojos.Nationality;
import com.test.microservices.repositories.NationalityRepository;

@RestController
public class NationalityController {
	NationalityRepository nationalityRepo;
	public NationalityController(NationalityRepository repo) {
		this.nationalityRepo=repo;
		// TODO Auto-generated constructor stub
	}
@GetMapping("/getNationalityByIdMongo/{id}")
public ResponseEntity<Nationality> getNationality( @PathVariable String id) {
	if(nationalityRepo.existsByIdMongo(id)) {
		Nationality ab=nationalityRepo.findByIdMongo( id);
		return new ResponseEntity<Nationality>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Nationality>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getNationalityById/{id}")
public ResponseEntity<Nationality> getNationality( @PathVariable int id) {
	if(nationalityRepo.existsById(id)) {
		Nationality ab=nationalityRepo.findById( id);
		return new ResponseEntity<Nationality>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Nationality>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getAllNationalitys")
public ResponseEntity<List<Nationality>> getNationality( ) {
	List<Nationality> lab=nationalityRepo.findAll();
	return new ResponseEntity<List<Nationality>>(lab,HttpStatus.OK);
}
@PostMapping("/addNationality")
public ResponseEntity<Nationality> addNationality(@RequestBody Nationality ab) {
	if(!nationalityRepo.existsById(ab.getId())) {
		nationalityRepo.save(ab);
		return new ResponseEntity<Nationality>(ab,HttpStatus.CREATED);
	}
	return new ResponseEntity<Nationality>(HttpStatus.CONFLICT);
}
@PutMapping("/updateNationality/{id}")
public ResponseEntity<Nationality> updateNationality(@PathVariable int id,@RequestBody Nationality ab) {
	if(nationalityRepo.existsById(id)) {
		nationalityRepo.save(ab);
		return new ResponseEntity<Nationality>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Nationality>(HttpStatus.NOT_FOUND);
}
@DeleteMapping("/deleteNationality/{id}")
public ResponseEntity<Nationality> deleteNationality(@PathVariable int id) {
	if(nationalityRepo.existsById(id)) {
		Nationality ab=nationalityRepo.deleteById(id);
		return new ResponseEntity<Nationality>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Nationality>(HttpStatus.NOT_FOUND);
}


}
