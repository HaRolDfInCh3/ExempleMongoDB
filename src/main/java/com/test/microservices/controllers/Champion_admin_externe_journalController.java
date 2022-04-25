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

import com.test.microservices.pojos.Champion_admin_externe_journal;
import com.test.microservices.repositories.ChampionAdminExterneJournalRepository;

@RestController
public class Champion_admin_externe_journalController {
	ChampionAdminExterneJournalRepository cAEJRepo;
	public Champion_admin_externe_journalController(ChampionAdminExterneJournalRepository repo) {
		this.cAEJRepo=repo;
		// TODO Auto-generated constructor stub
	}
@GetMapping("/getChampion_admin_externe_journalByIdMongo/{id}")
public ResponseEntity<Champion_admin_externe_journal> getChampion_admin_externe_journal( @PathVariable String id) {
	if(cAEJRepo.existsByIdMongo(id)) {
		Champion_admin_externe_journal ab=cAEJRepo.findByIdMongo( id);
		return new ResponseEntity<Champion_admin_externe_journal>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Champion_admin_externe_journal>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getChampion_admin_externe_journalById/{id}")
public ResponseEntity<Champion_admin_externe_journal> getChampion_admin_externe_journal( @PathVariable int id) {
	if(cAEJRepo.existsById(id)) {
		Champion_admin_externe_journal ab=cAEJRepo.findById( id);
		return new ResponseEntity<Champion_admin_externe_journal>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Champion_admin_externe_journal>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getAllChampion_admin_externe_journals")
public ResponseEntity<List<Champion_admin_externe_journal>> getChampion_admin_externe_journal( ) {
	List<Champion_admin_externe_journal> lab=cAEJRepo.findAll();
	return new ResponseEntity<List<Champion_admin_externe_journal>>(lab,HttpStatus.OK);
}
@PostMapping("/addChampion_admin_externe_journal")
public ResponseEntity<Champion_admin_externe_journal> addChampion_admin_externe_journal(@RequestBody Champion_admin_externe_journal ab) {
	if(!cAEJRepo.existsById(ab.getId())) {
		cAEJRepo.save(ab);
		return new ResponseEntity<Champion_admin_externe_journal>(ab,HttpStatus.CREATED);
	}
	return new ResponseEntity<Champion_admin_externe_journal>(HttpStatus.CONFLICT);
}
@PutMapping("/updateChampion_admin_externe_journal/{id}")
public ResponseEntity<Champion_admin_externe_journal> updateChampion_admin_externe_journal(@PathVariable int id,@RequestBody Champion_admin_externe_journal ab) {
	if(cAEJRepo.existsById(id)) {
		cAEJRepo.save(ab);
		return new ResponseEntity<Champion_admin_externe_journal>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Champion_admin_externe_journal>(HttpStatus.NOT_FOUND);
}
@DeleteMapping("/deleteChampion_admin_externe_journal/{id}")
public ResponseEntity<Champion_admin_externe_journal> deleteChampion_admin_externe_journal(@PathVariable int id) {
	if(cAEJRepo.existsById(id)) {
		Champion_admin_externe_journal ab=cAEJRepo.deleteById(id);
		return new ResponseEntity<Champion_admin_externe_journal>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Champion_admin_externe_journal>(HttpStatus.NOT_FOUND);
}


}
