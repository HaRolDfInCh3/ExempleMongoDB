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

import com.test.microservices.pojos.Image;
import com.test.microservices.repositories.ImagesRepository;

@RestController
public class ImagesController {
	ImagesRepository imageRepo;
	public ImagesController(ImagesRepository repo) {
		this.imageRepo=repo;
		// TODO Auto-generated constructor stub
	}
@GetMapping("/getImageByIdMongo/{id}")
public ResponseEntity<Image> getImage( @PathVariable String id) {
	if(imageRepo.existsByIdMongo(id)) {
		Image ab=imageRepo.findByIdMongo( id);
		return new ResponseEntity<Image>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Image>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getImageById/{id}")
public ResponseEntity<Image> getImage( @PathVariable int id) {
	if(imageRepo.existsById(id)) {
		Image ab=imageRepo.findById( id);
		return new ResponseEntity<Image>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Image>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getAllImages")
public ResponseEntity<List<Image>> getImage( ) {
	List<Image> lab=imageRepo.findAll();
	return new ResponseEntity<List<Image>>(lab,HttpStatus.OK);
}
@PostMapping("/addImage")
public ResponseEntity<Image> addImage(@RequestBody Image ab) {
	if(!imageRepo.existsById(ab.getId())) {
		imageRepo.save(ab);
		return new ResponseEntity<Image>(ab,HttpStatus.CREATED);
	}
	return new ResponseEntity<Image>(HttpStatus.CONFLICT);
}
@PutMapping("/updateImage/{id}")
public ResponseEntity<Image> updateImage(@PathVariable int id,@RequestBody Image ab) {
	if(imageRepo.existsById(id)) {
		imageRepo.save(ab);
		return new ResponseEntity<Image>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Image>(HttpStatus.NOT_FOUND);
}
@DeleteMapping("/deleteImage/{id}")
public ResponseEntity<Image> deleteImage(@PathVariable int id) {
	if(imageRepo.existsById(id)) {
		Image ab=imageRepo.deleteById(id);
		return new ResponseEntity<Image>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Image>(HttpStatus.NOT_FOUND);
}

}