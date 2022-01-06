package com.example.bancotqi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bancotqi.entities.Loan;
import com.example.bancotqi.repositories.LoanRepository;

@Service
public class LoanService {

	@Autowired
	private LoanRepository repository;

	public List<Loan> findAll() {

		List<Loan> list = repository.findAll();

		return list;
	}

	public Loan findById(long id) {

		Optional<Loan> obj = repository.findById(id);

		return obj.get();
	}
	
	public Loan insert(Loan obj) {
		
		obj = repository.save(obj);
		
		return obj;
	}
	
	
	



}
