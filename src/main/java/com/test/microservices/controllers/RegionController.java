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

import com.test.microservices.pojos.Region;
import com.test.microservices.repositories.RegionsRepository;

@RestController
public class RegionController {
	RegionsRepository regionRepo;
	public RegionController(RegionsRepository repo) {
		this.regionRepo=repo;
		// TODO Auto-generated constructor stub
	}
@GetMapping("/getRegionByIdMongo/{id}")
public ResponseEntity<Region> getRegion( @PathVariable String id) {
	if(regionRepo.existsByIdMongo(id)) {
		Region ab=regionRepo.findByIdMongo( id);
		return new ResponseEntity<Region>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Region>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getRegionById/{id}")
public ResponseEntity<Region> getRegion( @PathVariable int id) {
	if(regionRepo.existsById(id)) {
		Region ab=regionRepo.findById( id);
		return new ResponseEntity<Region>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Region>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getAllRegions")
public ResponseEntity<List<Region>> getRegion( ) {
	List<Region> lab=regionRepo.findAll();
	return new ResponseEntity<List<Region>>(lab,HttpStatus.OK);
}
@PostMapping("/addRegion")
public ResponseEntity<Region> addRegion(@RequestBody Region ab) {
	if(!regionRepo.existsById(ab.getId())) {
		regionRepo.save(ab);
		return new ResponseEntity<Region>(ab,HttpStatus.CREATED);
	}
	return new ResponseEntity<Region>(HttpStatus.CONFLICT);
}
@PutMapping("/updateRegion/{id}")
public ResponseEntity<Region> updateRegion(@PathVariable int id,@RequestBody Region ab) {
	if(regionRepo.existsById(id)) {
		regionRepo.save(ab);
		return new ResponseEntity<Region>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Region>(HttpStatus.NOT_FOUND);
}
@DeleteMapping("/deleteRegion/{id}")
public ResponseEntity<Region> deleteRegion(@PathVariable int id) {
	if(regionRepo.existsById(id)) {
		Region ab=regionRepo.deleteById(id);
		return new ResponseEntity<Region>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Region>(HttpStatus.NOT_FOUND);
}


}
