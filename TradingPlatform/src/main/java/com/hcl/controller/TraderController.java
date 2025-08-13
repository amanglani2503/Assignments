package com.hcl.controller;

import java.time.LocalDate;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.dto.TraderRequest;
import com.hcl.dto.TraderRequestTwo;
import com.hcl.entity.Trader;
import com.hcl.exception.UserAlreadyExists;
import com.hcl.exception.UserNotFoundException;
import com.hcl.service.TraderService;

@RestController
@RequestMapping("/trading/traders")
public class TraderController {

	private final TraderService traderService;

	public TraderController(TraderService traderService) {
		this.traderService = traderService;
	}

	@GetMapping("/all")
	public ResponseEntity<List<Trader>> getAll() {
		return ResponseEntity.ok(traderService.getAll());

	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getTrader(@PathVariable Long id) {
		try {
			return ResponseEntity.ok(traderService.getById(id));
		} catch (UserNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

		}
	}

	@PostMapping("/register")
	public ResponseEntity<?> createTrader(@RequestBody Trader trader) {
		try {
			trader.setCreatedAt(LocalDate.now().toString());
			trader.setUpdatedAt(LocalDate.now().toString());
			return ResponseEntity.status(HttpStatus.CREATED).body(traderService.createTrader(trader));
		} catch (UserAlreadyExists e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

		}
	}

	@PutMapping()

	public ResponseEntity<?> updateTrader(@RequestBody TraderRequest traderRequest) {
		try {
			Trader found = traderService.getByEmail(traderRequest.getEmail());

			if (found == null) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
			found.setName(traderRequest.getName());
			found.setUpdatedAt(LocalDate.now().toString());
			Trader updated = traderService.updateTrader(found);
			return ResponseEntity.status(HttpStatus.CREATED).body(updated);
		} catch (UserAlreadyExists e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

		}
	}

	@PutMapping("/add")

	public ResponseEntity<?> updateTraderbalance(@RequestBody TraderRequestTwo traderRequest) {

		Trader found = traderService.getByEmail(traderRequest.getEmail());
		System.out.println("foundUser:  " + found);
		if (found == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		found.setBalance(traderRequest.getBalance());
		found.setUpdatedAt(LocalDate.now().toString());
		Trader updated = traderService.updateTrader(found);
		return ResponseEntity.status(HttpStatus.CREATED).body(updated);

	}

	@GetMapping("/get-by-email")
	public ResponseEntity<?> findUserByEmail(@RequestParam("email") String email) {

		Trader found = traderService.getByEmail(email);
		System.out.println(found);
		if (found == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

		return ResponseEntity.status(HttpStatus.CREATED).body(found);
	}

}
