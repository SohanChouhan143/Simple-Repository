package com.citizenservice.in.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.citizenservice.in.entity.Citizen;
import com.citizenservice.in.repositories.CitizenRepo;

@RestController
@RequestMapping("/citizen")
public class CitizenController {
	
	@Autowired
	private CitizenRepo repo;
	
	@RequestMapping("/test2")
	public ResponseEntity<String> test(){
		return new ResponseEntity<String>("Hello", HttpStatus.OK);
	}
	
	@RequestMapping("/id/{id}")
	public ResponseEntity<List<Citizen>> findByid(@PathVariable Integer id){
		List<Citizen> list=repo.findByVaccinationId(id);
		return new ResponseEntity<List<Citizen>>(list, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Citizen> addCitizen(@RequestBody Citizen citizen){
		Citizen citizen1=repo.save(citizen);
		return new ResponseEntity<Citizen>(citizen1, HttpStatus.OK);
	}

}
