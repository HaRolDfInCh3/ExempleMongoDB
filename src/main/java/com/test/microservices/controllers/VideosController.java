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

import com.test.microservices.dto.VideoDto;
import com.test.microservices.mappers.VideoDtoToVideo;
import com.test.microservices.pojos.Video;
import com.test.microservices.repositories.VideosRepository;

@RestController
public class VideosController {
	VideosRepository videoRepo;
	VideoDtoToVideo mapper;
	public VideosController(VideosRepository repo,VideoDtoToVideo m) {
		this.videoRepo=repo;
		this.mapper=m;
		// TODO Auto-generated constructor stub
	}
@GetMapping("/getVideoByIdMongo/{id}")
public ResponseEntity<Video> getVideo( @PathVariable String id) {
	if(videoRepo.existsByIdMongo(id)) {
		Video ab=videoRepo.findByIdMongo( id);
		return new ResponseEntity<Video>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Video>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getVideoById/{id}")
public ResponseEntity<Video> getVideo( @PathVariable int id) {
	if(videoRepo.existsById(id)) {
		Video ab=videoRepo.findById( id);
		return new ResponseEntity<Video>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Video>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getAllVideos")
public ResponseEntity<List<Video>> getVideo( ) {
	List<Video> lab=videoRepo.findAll();
	return new ResponseEntity<List<Video>>(lab,HttpStatus.OK);
}
@PostMapping("/addVideo")
public ResponseEntity<VideoDto> addVideo(@RequestBody VideoDto ab) {
	if(!videoRepo.existsById(ab.getId())) {
		Video v=mapper.dtoToObject(ab);
		//videoRepo.save(v);
		System.out.println("videoDto : "+ab);
		System.out.println("video : "+v);
		return new ResponseEntity<VideoDto>(ab,HttpStatus.CREATED);
	}
	return new ResponseEntity<VideoDto>(HttpStatus.CONFLICT);
}
@PutMapping("/updateVideo/{id}")
public ResponseEntity<VideoDto> updateVideo(@PathVariable int id,@RequestBody VideoDto ab) {
	if(videoRepo.existsById(id)) {
		Video objet=mapper.dtoToObject(ab);
		//videoRepo.save(objet);
		System.out.println("videoDto : "+ab);
		System.out.println("video : "+objet);
		return new ResponseEntity<VideoDto>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<VideoDto>(HttpStatus.NOT_FOUND);
}
@DeleteMapping("/deleteVideo/{id}")
public ResponseEntity<Video> deleteVideo(@PathVariable int id) {
	if(videoRepo.existsById(id)) {
		Video ab=videoRepo.deleteById(id);
		return new ResponseEntity<Video>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Video>(HttpStatus.NOT_FOUND);
}


}
