package com.devsuperior.domain.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.domain.entities.Order;
import com.devsuperior.domain.exceptions.OrderNotFoundException;
import com.devsuperior.domain.repositories.OrderRepository;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {

	@Autowired
	private OrderRepository repository;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Order> findById(@PathVariable Long id) throws OrderNotFoundException {
		Optional<Order> objOpt = repository.findById(id);
		
		if(!objOpt.isPresent()) {
			return ResponseEntity.notFound().build();			
		}
		return ResponseEntity.ok(objOpt.get());
	}
}
