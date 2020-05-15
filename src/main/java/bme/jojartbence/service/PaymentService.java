package bme.jojartbence.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.stereotype.Service;

@Service
public class PaymentService {
	
	public PaymentService() {
		Properties props = new Properties();
		try {
			InputStream is = getClass().getClassLoader().getResourceAsStream("config.properties");
			props.load(is);
			baseBalance = Integer.parseInt(props.getProperty("basebalance"));
		} catch (Exception e) {
			baseBalance = 100000;
			e.printStackTrace();
		}
		
	}

	public double getBalance() {
		return balance;
	}

	private double balance = 0;
	
	public void withdraw(double value) {
		balance -= value;
	}
	
	public double getRecommendedDeposit() {
		return baseBalance - balance;
	}
	
	public double deposit(double value) {
		balance += value;
		return value;
	}
	
	private int baseBalance;
}
