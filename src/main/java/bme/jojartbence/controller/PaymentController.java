package bme.jojartbence.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import bme.jojartbence.service.PaymentService;


/**
 * @author Bence Jójárt <jojart.bence96@gmail.com>
 * @version 1.0
 * @since 1.0
 * 
 * This class handles REST HTTP requests related to payment. Handled by spring framework.
 */
@RestController
public class PaymentController {

	/**
	 * Service behind the controller.
	 */
	@Autowired
	PaymentService paymentService;
	
	/**
	 * This function is called when a HTTP GET request occurs to /payment/recommended.
	 * 
	 * @return Recommended payment calculated by the application.
	 */
	@GetMapping("/payment/recommended")
	public double getRecommendedDeposit() {
		return paymentService.getRecommendedDeposit();
	}
	
	/**
	 * This function is called when a HTTP POST request occurs to /payment/deposit.
	 * 
	 * @param value Deposited money. 
	 * @return deposited money. 
	 */
	@PostMapping("/payment/deposit")
	public double deposit(@RequestBody double value) {
		return paymentService.deposit(value);
	}
	
}
