package com.example.bancotqi.services;

import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;
import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.bancotqi.entities.User;
import com.example.bancotqi.repositories.UserRepository;
import com.example.bancotqi.services.exceptions.DatabaseException;
import com.example.bancotqi.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public List<User> findAll() {

		List<User> list = repository.findAll();

		return list;
	}

	public User findById(Long id) {

		Optional<User> obj = repository.findById(id);

		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public User insert(User obj) {

		obj = repository.save(obj);

		return obj;
	}

	public User update(long id, User obj) {
		try {
			User entity = repository.getOne(id);

			updateData(entity, obj);

			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			e.printStackTrace();
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(User obj, User mod) {

		obj.setName(mod.getName());
		obj.setEndereço(mod.getEndereço());
		obj.setEmail(mod.getEmail());
	}

	public void delete(Long id) {
		try {

			repository.deleteById(id);

		} catch (EmptyResultDataAccessException e) {

			throw new ResourceNotFoundException(id);

		} catch (DataIntegrityViolationException e) {

			throw new DatabaseException(e.getMessage());
		}

	}

}
