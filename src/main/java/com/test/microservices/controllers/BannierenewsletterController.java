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

import com.test.microservices.pojos.Bannierenewsletter;
import com.test.microservices.repositories.BnRepository;

@RestController
public class BannierenewsletterController {
	BnRepository bnRepo;
	public BannierenewsletterController(BnRepository repo) {
		this.bnRepo=repo;
		// TODO Auto-generated constructor stub
	}
@GetMapping("/getBannierenewsletterByIdMongo/{id}")
public ResponseEntity<Bannierenewsletter> getBannierenewsletter( @PathVariable String id) {
	if(bnRepo.existsByIdMongo(id)) {
		Bannierenewsletter ab=bnRepo.findByIdMongo( id);
		return new ResponseEntity<Bannierenewsletter>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Bannierenewsletter>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getBannierenewsletterById/{id}")
public ResponseEntity<Bannierenewsletter> getBannierenewsletter( @PathVariable int id) {
	if(bnRepo.existsById(id)) {
		Bannierenewsletter ab=bnRepo.findById( id);
		return new ResponseEntity<Bannierenewsletter>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Bannierenewsletter>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getAllBannierenewsletters")
public ResponseEntity<List<Bannierenewsletter>> getBannierenewsletter( ) {
	List<Bannierenewsletter> lab=bnRepo.findAll();
	return new ResponseEntity<List<Bannierenewsletter>>(lab,HttpStatus.OK);
}
@PostMapping("/addBannierenewsletter")
public ResponseEntity<Bannierenewsletter> addBannierenewsletter(@RequestBody Bannierenewsletter ab) {
	if(!bnRepo.existsById(ab.getId())) {
		bnRepo.save(ab);
		return new ResponseEntity<Bannierenewsletter>(ab,HttpStatus.CREATED);
	}
	return new ResponseEntity<Bannierenewsletter>(HttpStatus.CONFLICT);
}
@PutMapping("/updateBannierenewsletter/{id}")
public ResponseEntity<Bannierenewsletter> updateBannierenewsletter(@PathVariable int id,@RequestBody Bannierenewsletter ab) {
	if(bnRepo.existsById(id)) {
		bnRepo.save(ab);
		return new ResponseEntity<Bannierenewsletter>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Bannierenewsletter>(HttpStatus.NOT_FOUND);
}
@DeleteMapping("/deleteBannierenewsletter/{id}")
public ResponseEntity<Bannierenewsletter> deleteBannierenewsletter(@PathVariable int id) {
	if(bnRepo.existsById(id)) {
		Bannierenewsletter ab=bnRepo.deleteById(id);
		return new ResponseEntity<Bannierenewsletter>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Bannierenewsletter>(HttpStatus.NOT_FOUND);
}


}
