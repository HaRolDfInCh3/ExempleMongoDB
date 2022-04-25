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

import com.test.microservices.pojos.Option;
import com.test.microservices.repositories.OptionsRepository;

@RestController
public class OptionsController {
	OptionsRepository optionRepo;
	public OptionsController(OptionsRepository repo) {
		this.optionRepo=repo;
		// TODO Auto-generated constructor stub
	}
@GetMapping("/getOptionByIdMongo/{id}")
public ResponseEntity<Option> getOption( @PathVariable String id) {
	if(optionRepo.existsByIdMongo(id)) {
		Option ab=optionRepo.findByIdMongo( id);
		return new ResponseEntity<Option>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Option>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getOptionById/{id}")
public ResponseEntity<Option> getOption( @PathVariable int id) {
	if(optionRepo.existsById(id)) {
		Option ab=optionRepo.findById( id);
		return new ResponseEntity<Option>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Option>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getAllOptions")
public ResponseEntity<List<Option>> getOption( ) {
	List<Option> lab=optionRepo.findAll();
	return new ResponseEntity<List<Option>>(lab,HttpStatus.OK);
}
@PostMapping("/addOption")
public ResponseEntity<Option> addOption(@RequestBody Option ab) {
	if(!optionRepo.existsById(ab.getId())) {
		optionRepo.save(ab);
		return new ResponseEntity<Option>(ab,HttpStatus.CREATED);
	}
	return new ResponseEntity<Option>(HttpStatus.CONFLICT);
}
@PutMapping("/updateOption/{id}")
public ResponseEntity<Option> updateOption(@PathVariable int id,@RequestBody Option ab) {
	if(optionRepo.existsById(id)) {
		optionRepo.save(ab);
		return new ResponseEntity<Option>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Option>(HttpStatus.NOT_FOUND);
}
@DeleteMapping("/deleteOption/{id}")
public ResponseEntity<Option> deleteOption(@PathVariable int id) {
	if(optionRepo.existsById(id)) {
		Option ab=optionRepo.deleteById(id);
		return new ResponseEntity<Option>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Option>(HttpStatus.NOT_FOUND);
}


}
