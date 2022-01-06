package com.example.bancotqi.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.bancotqi.entities.Loan;
import com.example.bancotqi.entities.Order;
import com.example.bancotqi.entities.OrderLoan;
import com.example.bancotqi.entities.User;
import com.example.bancotqi.repositories.LoanRepository;
import com.example.bancotqi.repositories.OrderLoanRepository;
import com.example.bancotqi.repositories.OrderRepository;
import com.example.bancotqi.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private LoanRepository loanRepository;

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private OrderLoanRepository orderLoanRepository;
	
	@Override
	public void run(String... args) throws Exception {

		User u1 = new User(null, "amintas","amintas@tqi.com" ,"123423232", "1231231", "rua bernardo cupertino 1692"
				+ " ", 2200.00, "1234");	
		userRepository.saveAll(Arrays.asList(u1));
				
		Order o1 = new Order(null, Instant.now(), u1);
		
		Loan l1 = new Loan(null, 2200.00, Instant.parse("2019-06-20T19:53:07Z"), 4);
		
		OrderLoan ol = new OrderLoan(o1, l1, 1, l1.getValue());
		
		loanRepository.save(l1);
		orderRepository.save(o1);
		orderLoanRepository.save(ol);
	}

}
