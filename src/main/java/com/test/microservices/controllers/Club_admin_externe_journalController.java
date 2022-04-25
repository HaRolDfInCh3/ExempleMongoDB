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

import com.test.microservices.pojos.Club_admin_externe_journal;
import com.test.microservices.repositories.Club_admin_externe_journalRepository;
@RestController
public class Club_admin_externe_journalController {
	Club_admin_externe_journalRepository club_admin_externe_journalRepo;
	public Club_admin_externe_journalController(Club_admin_externe_journalRepository repo) {
		this.club_admin_externe_journalRepo=repo;
		// TODO Auto-generated constructor stub
	}
@GetMapping("/getClub_admin_externe_journalByIdMongo/{id}")
public ResponseEntity<Club_admin_externe_journal> getClub_admin_externe_journal( @PathVariable String id) {
	if(club_admin_externe_journalRepo.existsByIdMongo(id)) {
		Club_admin_externe_journal ab=club_admin_externe_journalRepo.findByIdMongo( id);
		return new ResponseEntity<Club_admin_externe_journal>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Club_admin_externe_journal>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getClub_admin_externe_journalById/{id}")
public ResponseEntity<Club_admin_externe_journal> getClub_admin_externe_journal( @PathVariable int id) {
	if(club_admin_externe_journalRepo.existsById(id)) {
		Club_admin_externe_journal ab=club_admin_externe_journalRepo.findById( id);
		return new ResponseEntity<Club_admin_externe_journal>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Club_admin_externe_journal>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getAllClub_admin_externe_journals")
public ResponseEntity<List<Club_admin_externe_journal>> getClub_admin_externe_journal( ) {
	List<Club_admin_externe_journal> lab=club_admin_externe_journalRepo.findAll();
	return new ResponseEntity<List<Club_admin_externe_journal>>(lab,HttpStatus.OK);
}
@PostMapping("/addClub_admin_externe_journal")
public ResponseEntity<Club_admin_externe_journal> addClub_admin_externe_journal(@RequestBody Club_admin_externe_journal ab) {
	if(!club_admin_externe_journalRepo.existsById(ab.getId())) {
		club_admin_externe_journalRepo.save(ab);
		return new ResponseEntity<Club_admin_externe_journal>(ab,HttpStatus.CREATED);
	}
	return new ResponseEntity<Club_admin_externe_journal>(HttpStatus.CONFLICT);
}
@PutMapping("/updateClub_admin_externe_journal/{id}")
public ResponseEntity<Club_admin_externe_journal> updateClub_admin_externe_journal(@PathVariable int id,@RequestBody Club_admin_externe_journal ab) {
	if(club_admin_externe_journalRepo.existsById(id)) {
		club_admin_externe_journalRepo.save(ab);
		return new ResponseEntity<Club_admin_externe_journal>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Club_admin_externe_journal>(HttpStatus.NOT_FOUND);
}
@DeleteMapping("/deleteClub_admin_externe_journal/{id}")
public ResponseEntity<Club_admin_externe_journal> deleteClub_admin_externe_journal(@PathVariable int id) {
	if(club_admin_externe_journalRepo.existsById(id)) {
		Club_admin_externe_journal ab=club_admin_externe_journalRepo.deleteById(id);
		return new ResponseEntity<Club_admin_externe_journal>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Club_admin_externe_journal>(HttpStatus.NOT_FOUND);
}


}
