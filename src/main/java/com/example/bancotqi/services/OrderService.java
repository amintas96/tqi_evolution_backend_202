package com.example.bancotqi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bancotqi.entities.Order;
import com.example.bancotqi.repositories.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository repository;

	public List<Order> findAll() {

		List<Order> list = repository.findAll();

		return list;
	}

	public Order findById(long id) {

		Optional<Order> obj = repository.findById(id);

		return obj.get();
	}
	
	public Order insert(Order obj) {		
		
		obj = repository.save(obj);
		
		return obj;
	}
	


	
}
