package com.example.bancotqi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bancotqi.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
