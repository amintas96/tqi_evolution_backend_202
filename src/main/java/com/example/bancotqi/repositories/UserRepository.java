package com.example.bancotqi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bancotqi.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
