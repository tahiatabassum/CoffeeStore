package com.cs.demo.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cs.demo.entity.Coffee;
import com.cs.demo.exceptions.ResourceNotFoundException;
import com.cs.demo.repository.CoffeeRepository;

@RestController
@RequestMapping ("/api/v1/coffeebar") 
public class CoffeeController {

@Autowired
private CoffeeRepository coffeeRepository;


@GetMapping("/coffee") //http://localhost8080/api/v1/coffee
public List<Coffee> getAllCoffee() {
	return coffeeRepository.findAll();
}

@GetMapping("/coffee/{id}") //http://localhost8080/api/v1/coffeebar/coffee/{id}
public ResponseEntity<Coffee> findById(@PathVariable (value = "id")Long Coffeeid) 
throws ResourceNotFoundException{
	Coffee coffee = coffeeRepository.findById(Coffeeid)
			.orElseThrow(() -> new ResourceNotFoundException ("Coffee Not Found"));
	return ResponseEntity.ok().body(coffee);
}

@PutMapping ("/coffee")

public ResponseEntity<Coffee> updateCoffee(@PathVariable (value = "id")Long Coffeeid,
		@Valid @RequestBody Coffee coffeeDetails) 
throws ResourceNotFoundException{
	Coffee coffee = coffeeRepository.findById(Coffeeid)
			.orElseThrow(() -> new ResourceNotFoundException ("Coffee Not Found"));
	
	coffee.setName(coffeeDetails.getName());
	coffee.setDiscription(coffeeDetails.getDiscription());
	coffee.setCost(coffeeDetails.getCost());
	
	final Coffee coffeeUpdated = coffeeRepository.save(coffee);
			
	return ResponseEntity.ok().body(coffeeUpdated);
	
}

@PostMapping("/coffee")
public Coffee createCoffee(@Valid @RequestBody Coffee coffee) {
	return coffeeRepository.save(coffee);
}
	
@DeleteMapping("/coffee/{id}") //http://localhost8080/api/v1/coffeebar/coffee/{id}
public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long Coffeeid)
		throws ResourceNotFoundException {
	Coffee coffee = coffeeRepository.findById(Coffeeid)
			.orElseThrow(() -> new ResourceNotFoundException("Coffee not found"));

	coffeeRepository.delete(coffee);
	Map<String, Boolean> response = new HashMap<>();
	response.put("deleted", Boolean.TRUE);
	return response;
}


}
