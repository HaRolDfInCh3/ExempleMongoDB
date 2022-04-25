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

import com.test.microservices.pojos.Club;
import com.test.microservices.repositories.ClubsRepository;
@RestController
public class ClubController {
	ClubsRepository clubRepo;
	public ClubController(ClubsRepository repo) {
		this.clubRepo=repo;
		// TODO Auto-generated constructor stub
	}
@GetMapping("/getClubByIdMongo/{id}")
public ResponseEntity<Club> getClub( @PathVariable String id) {
	if(clubRepo.existsByIdMongo(id)) {
		Club ab=clubRepo.findByIdMongo( id);
		return new ResponseEntity<Club>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Club>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getClubById/{id}")
public ResponseEntity<Club> getClub( @PathVariable int id) {
	if(clubRepo.existsById(id)) {
		Club ab=clubRepo.findById( id);
		return new ResponseEntity<Club>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Club>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getAllClubs")
public ResponseEntity<List<Club>> getClub( ) {
	List<Club> lab=clubRepo.findAll();
	return new ResponseEntity<List<Club>>(lab,HttpStatus.OK);
}
@PostMapping("/addClub")
public ResponseEntity<Club> addClub(@RequestBody Club ab) {
	if(!clubRepo.existsById(ab.getId())) {
		clubRepo.save(ab);
		return new ResponseEntity<Club>(ab,HttpStatus.CREATED);
	}
	return new ResponseEntity<Club>(HttpStatus.CONFLICT);
}
@PutMapping("/updateClub/{id}")
public ResponseEntity<Club> updateClub(@PathVariable int id,@RequestBody Club ab) {
	if(clubRepo.existsById(id)) {
		clubRepo.save(ab);
		return new ResponseEntity<Club>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Club>(HttpStatus.NOT_FOUND);
}
@DeleteMapping("/deleteClub/{id}")
public ResponseEntity<Club> deleteClub(@PathVariable int id) {
	if(clubRepo.existsById(id)) {
		Club ab=clubRepo.deleteById(id);
		return new ResponseEntity<Club>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Club>(HttpStatus.NOT_FOUND);
}


}
