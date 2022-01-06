package com.example.bancotqi.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bancotqi.entities.Loan;
import com.example.bancotqi.services.LoanService;

@RestController
@RequestMapping(value = "/loans")
public class LoanResource {

	@Autowired
	private LoanService service;

	@GetMapping
	public ResponseEntity<List<Loan>> findAll() {
		List<Loan> list = service.findAll();

		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "{id}")
	public ResponseEntity<Loan> findById(@PathVariable Long id) {
		
		Loan obj = service.findById(id);
		
		return ResponseEntity.ok().body(obj);
		
	}
	
	@PostMapping
	public ResponseEntity<Loan> insert (@RequestBody Loan obj){
		
		obj = service.insert(obj);
		
		return ResponseEntity.ok().body(obj);
				
	}
	
	

}
