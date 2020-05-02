package bme.jojartbence.service;

import org.springframework.stereotype.Service;

@Service
public class PaymentService {

	public double getBalance() {
		return balance;
	}

	private double balance = 0;
	
	public void withdraw(double value) {
		balance -= value;
	}
	
	public double getRecommendedDeposit() {
		return 100000 - balance;
	}
	
	public double deposit(double value) {
		balance += value;
		return value;
	}
}
