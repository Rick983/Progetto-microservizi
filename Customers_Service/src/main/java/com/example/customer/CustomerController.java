package com.example.customer;

import org.springframework.web.bind.annotation.DeleteMapping;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController

public class CustomerController {
	
	private final CustomerRepository customerRepository;
	
	CustomerController(CustomerRepository repository) {
		customerRepository = repository;
	}
	
	@GetMapping("/customers")
	Iterable<Customer> getCustomers() {
		return customerRepository.findAll();
	}
	
	@GetMapping("/customers/{customerId}")
	Customer getCustomer(@PathVariable Long customerId) {
		return customerRepository.findById(customerId).orElseThrow();
	}
	
	@PostMapping("/customers")
	Customer createCustomer(@RequestBody Customer newCustomer ) {
		return customerRepository.save(newCustomer);
	}
	
	@PutMapping("/customers/{customerId}")
	Customer updateCustomer(@PathVariable Long customerId, @RequestBody Customer customerDto) {
		Customer customerToUpdate = customerRepository.findById(customerId).orElseThrow();
		customerToUpdate.setName(customerDto.getName());
		customerToUpdate.setSurname(customerDto.getSurname());
		customerToUpdate.setMail(customerDto.getMail());
		return customerRepository.save(customerToUpdate);
	}
	
	@DeleteMapping("/customers/{customerId}")
	void deleteCustomer(@PathVariable Long customerId) {
		Customer customer = customerRepository.findById(customerId).orElseThrow();
		customerRepository.delete(customer);
		
	}
	


}
   