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

import com.test.microservices.pojos.Bannierebackground;
import com.test.microservices.repositories.BbRepository;

@RestController
public class BannierebackgroundController {
	BbRepository bbRepo;
	public BannierebackgroundController(BbRepository repo) {
		this.bbRepo=repo;
		// TODO Auto-generated constructor stub
	}
@GetMapping("/getBannierebackgroundByIdMongo/{id}")
public ResponseEntity<Bannierebackground> getBannierebackground( @PathVariable String id) {
	if(bbRepo.existsByIdMongo(id)) {
		Bannierebackground ab=bbRepo.findByIdMongo( id);
		return new ResponseEntity<Bannierebackground>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Bannierebackground>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getBannierebackgroundById/{id}")
public ResponseEntity<Bannierebackground> getBannierebackground( @PathVariable int id) {
	if(bbRepo.existsById(id)) {
		Bannierebackground ab=bbRepo.findById( id);
		return new ResponseEntity<Bannierebackground>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Bannierebackground>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getAllBannierebackgrounds")
public ResponseEntity<List<Bannierebackground>> getBannierebackground( ) {
	List<Bannierebackground> lab=bbRepo.findAll();
	return new ResponseEntity<List<Bannierebackground>>(lab,HttpStatus.OK);
}
@PostMapping("/addBannierebackground")
public ResponseEntity<Bannierebackground> addBannierebackground(@RequestBody Bannierebackground ab) {
	if(!bbRepo.existsById(ab.getId())) {
		bbRepo.save(ab);
		return new ResponseEntity<Bannierebackground>(ab,HttpStatus.CREATED);
	}
	return new ResponseEntity<Bannierebackground>(HttpStatus.CONFLICT);
}
@PutMapping("/updateBannierebackground/{id}")
public ResponseEntity<Bannierebackground> updateBannierebackground(@PathVariable int id,@RequestBody Bannierebackground ab) {
	if(bbRepo.existsById(id)) {
		bbRepo.save(ab);
		return new ResponseEntity<Bannierebackground>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Bannierebackground>(HttpStatus.NOT_FOUND);
}
@DeleteMapping("/deleteBannierebackground/{id}")
public ResponseEntity<Bannierebackground> deleteBannierebackground(@PathVariable int id) {
	if(bbRepo.existsById(id)) {
		Bannierebackground ab=bbRepo.deleteById(id);
		return new ResponseEntity<Bannierebackground>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Bannierebackground>(HttpStatus.NOT_FOUND);
}

}
