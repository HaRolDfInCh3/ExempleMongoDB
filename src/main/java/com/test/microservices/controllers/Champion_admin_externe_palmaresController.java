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

import com.test.microservices.pojos.Champion_admin_externe_palmares;
import com.test.microservices.repositories.ChampionAdminExternePalmaresRepository;
@RestController
public class Champion_admin_externe_palmaresController {
	ChampionAdminExternePalmaresRepository cAEPRepo;
	public Champion_admin_externe_palmaresController(ChampionAdminExternePalmaresRepository repo) {
		this.cAEPRepo=repo;
		// TODO Auto-generated constructor stub
	}
@GetMapping("/getChampion_admin_externe_palmaresByIdMongo/{id}")
public ResponseEntity<Champion_admin_externe_palmares> getChampion_admin_externe_palmares( @PathVariable String id) {
	if(cAEPRepo.existsByIdMongo(id)) {
		Champion_admin_externe_palmares ab=cAEPRepo.findByIdMongo( id);
		return new ResponseEntity<Champion_admin_externe_palmares>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Champion_admin_externe_palmares>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getChampion_admin_externe_palmaresById/{id}")
public ResponseEntity<Champion_admin_externe_palmares> getChampion_admin_externe_palmares( @PathVariable int id) {
	if(cAEPRepo.existsById(id)) {
		Champion_admin_externe_palmares ab=cAEPRepo.findById( id);
		return new ResponseEntity<Champion_admin_externe_palmares>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Champion_admin_externe_palmares>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getAllChampion_admin_externe_palmaress")
public ResponseEntity<List<Champion_admin_externe_palmares>> getChampion_admin_externe_palmares( ) {
	List<Champion_admin_externe_palmares> lab=cAEPRepo.findAll();
	return new ResponseEntity<List<Champion_admin_externe_palmares>>(lab,HttpStatus.OK);
}
@PostMapping("/addChampion_admin_externe_palmares")
public ResponseEntity<Champion_admin_externe_palmares> addChampion_admin_externe_palmares(@RequestBody Champion_admin_externe_palmares ab) {
	if(!cAEPRepo.existsById(ab.getId())) {
		cAEPRepo.save(ab);
		return new ResponseEntity<Champion_admin_externe_palmares>(ab,HttpStatus.CREATED);
	}
	return new ResponseEntity<Champion_admin_externe_palmares>(HttpStatus.CONFLICT);
}
@PutMapping("/updateChampion_admin_externe_palmares/{id}")
public ResponseEntity<Champion_admin_externe_palmares> updateChampion_admin_externe_palmares(@PathVariable int id,@RequestBody Champion_admin_externe_palmares ab) {
	if(cAEPRepo.existsById(id)) {
		cAEPRepo.save(ab);
		return new ResponseEntity<Champion_admin_externe_palmares>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Champion_admin_externe_palmares>(HttpStatus.NOT_FOUND);
}
@DeleteMapping("/deleteChampion_admin_externe_palmares/{id}")
public ResponseEntity<Champion_admin_externe_palmares> deleteChampion_admin_externe_palmares(@PathVariable int id) {
	if(cAEPRepo.existsById(id)) {
		Champion_admin_externe_palmares ab=cAEPRepo.deleteById(id);
		return new ResponseEntity<Champion_admin_externe_palmares>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Champion_admin_externe_palmares>(HttpStatus.NOT_FOUND);
}


}
