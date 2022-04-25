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

import com.test.microservices.pojos.Admin;
import com.test.microservices.repositories.AdminRepository;

@RestController
public class AdminController {
	AdminRepository adminRepo;
	public AdminController(AdminRepository repo) {
		this.adminRepo=repo;
		// TODO Auto-generated constructor stub
	}
@GetMapping("/getAdminByIdMongo/{id}")
public ResponseEntity<Admin> getAdmin( @PathVariable String id) {
	if(adminRepo.existsByIdMongo(id)) {
		Admin ab=adminRepo.findByIdMongo( id);
		return new ResponseEntity<Admin>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Admin>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getAdminById/{id}")
public ResponseEntity<Admin> getAdmin( @PathVariable int id) {
	if(adminRepo.existsByAdminId(id)) {
		Admin ab=adminRepo.findByAdminId( id);
		return new ResponseEntity<Admin>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Admin>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getAllAdmins")
public ResponseEntity<List<Admin>> getAdmin( ) {
	List<Admin> lab=adminRepo.findAll();
	return new ResponseEntity<List<Admin>>(lab,HttpStatus.OK);
}
@PostMapping("/addAdmin")
public ResponseEntity<Admin> addAdmin(@RequestBody Admin ab) {
	if(!adminRepo.existsByAdminId(ab.getAdminId())) {
		adminRepo.save(ab);
		return new ResponseEntity<Admin>(ab,HttpStatus.CREATED);
	}
	return new ResponseEntity<Admin>(HttpStatus.CONFLICT);
}
@PutMapping("/updateAdmin/{id}")
public ResponseEntity<Admin> updateAdmin(@PathVariable int id,@RequestBody Admin ab) {
	if(adminRepo.existsByAdminId(id)) {
		adminRepo.save(ab);
		return new ResponseEntity<Admin>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Admin>(HttpStatus.NOT_FOUND);
}
@DeleteMapping("/deleteAdmin/{id}")
public ResponseEntity<Admin> deleteAdmin(@PathVariable int id) {
	if(adminRepo.existsByAdminId(id)) {
		Admin ab=adminRepo.deleteByAdminId(id);
		return new ResponseEntity<Admin>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Admin>(HttpStatus.NOT_FOUND);
}
}
