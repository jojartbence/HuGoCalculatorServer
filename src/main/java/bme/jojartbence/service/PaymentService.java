package bme.jojartbence.service;

import java.io.InputStream;
import java.util.Properties;

import org.springframework.stereotype.Service;


/**
 * @author Bence Jójárt <jojart.bence96@gmail.com>
 * @version 1.0
 * @since 1.0
 * 
 * Service class for handling payments.
 */
@Service
public class PaymentService {
	
	/**
	 * Constructor. Base balance is read from config.properties file.
	 */
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
		balance = baseBalance;
	}

	/**
	 * Function for getting actual balance.
	 * 
	 * @return Actual balance.
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * Actual balance.
	 */
	private double balance = 0;
	
	/**
	 * Withdraw money.
	 * 
	 * @param value Value of withdrawal.
	 */
	public void withdraw(double value) {
		balance -= value;
	}
	
	/**
	 * Get recommended deposit.
	 * 
	 * @return Recommended deposit.
	 */
	public double getRecommendedDeposit() {
		return baseBalance - balance;
	}
	
	/**
	 * Deposit balance.
	 * 
	 * @param value Value of deposit.
	 * @return Value of deposit.
	 */
	public double deposit(double value) {
		balance += value;
		return value;
	}
	
	/**
	 * Base balance.
	 * The application recommends the deposit in the way that balance get equals with base balance.
	 */
	private int baseBalance;
}
