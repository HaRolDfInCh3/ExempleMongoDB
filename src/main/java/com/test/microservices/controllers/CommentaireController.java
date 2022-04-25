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

import com.test.microservices.pojos.Commentaire;
import com.test.microservices.repositories.CommentairesRepository;
@RestController
public class CommentaireController {
	CommentairesRepository commentaireRepo;
	public CommentaireController(CommentairesRepository repo) {
		this.commentaireRepo=repo;
		// TODO Auto-generated constructor stub
	}
@GetMapping("/getCommentaireByIdMongo/{id}")
public ResponseEntity<Commentaire> getCommentaire( @PathVariable String id) {
	if(commentaireRepo.existsByIdMongo(id)) {
		Commentaire ab=commentaireRepo.findByIdMongo( id);
		return new ResponseEntity<Commentaire>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Commentaire>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getCommentaireById/{id}")
public ResponseEntity<Commentaire> getCommentaire( @PathVariable int id) {
	if(commentaireRepo.existsById(id)) {
		Commentaire ab=commentaireRepo.findById( id);
		return new ResponseEntity<Commentaire>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Commentaire>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getAllCommentaires")
public ResponseEntity<List<Commentaire>> getCommentaire( ) {
	List<Commentaire> lab=commentaireRepo.findAll();
	return new ResponseEntity<List<Commentaire>>(lab,HttpStatus.OK);
}
@PostMapping("/addCommentaire")
public ResponseEntity<Commentaire> addCommentaire(@RequestBody Commentaire ab) {
	if(!commentaireRepo.existsById(ab.getId())) {
		commentaireRepo.save(ab);
		return new ResponseEntity<Commentaire>(ab,HttpStatus.CREATED);
	}
	return new ResponseEntity<Commentaire>(HttpStatus.CONFLICT);
}
@PutMapping("/updateCommentaire/{id}")
public ResponseEntity<Commentaire> updateCommentaire(@PathVariable int id,@RequestBody Commentaire ab) {
	if(commentaireRepo.existsById(id)) {
		commentaireRepo.save(ab);
		return new ResponseEntity<Commentaire>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Commentaire>(HttpStatus.NOT_FOUND);
}
@DeleteMapping("/deleteCommentaire/{id}")
public ResponseEntity<Commentaire> deleteCommentaire(@PathVariable int id) {
	if(commentaireRepo.existsById(id)) {
		Commentaire ab=commentaireRepo.deleteById(id);
		return new ResponseEntity<Commentaire>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Commentaire>(HttpStatus.NOT_FOUND);
}


}
