package bme.jojartbence.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import bme.jojartbence.service.PaymentService;

@RestController
public class PaymentController {

	@Autowired
	PaymentService paymentService;
	
	
	@GetMapping("/payment/recommended")
	public double getRecommendedDeposit() {
		return paymentService.getRecommendedDeposit();
	}
	
	@PostMapping("/payment/deposit")
	public double deposit(@RequestBody double value) {
		return paymentService.deposit(value);
	}
	
}
