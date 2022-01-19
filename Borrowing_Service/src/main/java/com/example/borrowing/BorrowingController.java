package com.example.borrowing;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BorrowingController {

	private final BorrowingRepository borrowingRepository;
	
	BorrowingController(BorrowingRepository repository) {
		borrowingRepository = repository;
	}

	@GetMapping("/borrowings")
	Iterable<Borrowing> getBorrowings() {
		return borrowingRepository.findAll();
	}
	
	@GetMapping("/borrowings/{borrowingId}")
	Borrowing getBorrowing(@PathVariable Long borrowingId) {
		return borrowingRepository.findById(borrowingId).orElseThrow();
	}
	
	@GetMapping("/borrowings/{customerId}")
	Borrowing getCustomer(@PathVariable Long customerId) {
		return borrowingRepository.findById(customerId).orElseThrow();
	}
	
	@PostMapping("/borrowings")
	Borrowing createBorrowing(@RequestBody Borrowing newBorrowing ) {
		return borrowingRepository.save(newBorrowing);
	}
	
	@PutMapping("/borrowings/{borrowingId}")
	Borrowing updateBorrowing(@PathVariable Long borrowingId, @RequestBody Borrowing borrowingDto) {
		Borrowing borrowingToUpdate = borrowingRepository.findById(borrowingId).orElseThrow();
		borrowingToUpdate.setBookID(borrowingDto.getBookID());
		borrowingToUpdate.setCustomerID(borrowingDto.getCustomerID());
		borrowingToUpdate.setDateStart(borrowingDto.getDateStart());
		borrowingToUpdate.setDateEnd(borrowingDto.getDateEnd());
		return borrowingRepository.save(borrowingToUpdate);
	}
	
	@DeleteMapping("/borrowings/{borrowingId}")
	void deleteBorrowing(@PathVariable Long borrowingId) {
		Borrowing borrowing = borrowingRepository.findById(borrowingId).orElseThrow();
		borrowingRepository.delete(borrowing);
		
	}

}
