package com.example.bancotqi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bancotqi.entities.Loan;

public interface LoanRepository extends JpaRepository<Loan, Long>{

}
