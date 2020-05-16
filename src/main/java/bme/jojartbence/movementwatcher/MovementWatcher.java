package bme.jojartbence.movementwatcher;


import java.util.TimerTask;

import bme.jojartbence.model.Movement;
import bme.jojartbence.service.MovementService;
import bme.jojartbence.service.PaymentService;


/**
 * @author Bence Jójárt <jojart.bence96@gmail.com>
 * @version 1.0
 * @since 1.0
 * 
 * Class for handling timer events, 
 * when the movement becomes obsolete and money has to be withdrawed.
 */
public class MovementWatcher extends TimerTask {

	public MovementWatcher(Movement movement, PaymentService paymentService, MovementService movementService) {
		super();
		this.movement = movement;
		this.paymentService = paymentService;
		this.movementService = movementService;
	}

	/**
	 * Movement of whom the expire time is to be watched,
	 */
	private Movement movement;

	/**
	 * Payment service to notify when movement expires.
	 */
	PaymentService paymentService;
	
	/**
	 * Movement service to notify when movement expires.
	 */
	MovementService movementService;
	
	/**
	 * Called when the TimerTask expires.
	 */
	public void run() {
		movementOverCallback();
	}
	
	/**
	 * Callback function. Called when timer task expires.
	 * Notifies payment service with the money to be withdrawed.
	 * Notities movement service with the obsolete movement to be deleted.
	 */
	private void movementOverCallback() {
		System.out.println("Movement over: deleting from database & withdrawing money from balance");
		
		PriceCalculator calculator = new PriceCalculator(movement);
		
		paymentService.withdraw(calculator.calculatePrice());
		movementService.deleteMovement(movement);
	}
	
	
	/**
	 * @author Bence Jójárt <jojart.bence96@gmail.com>
	 * @version 1.0
	 * @since 1.0
	 * 
	 * Helper class for calculating the HU-GO toll.
	 */
	private class PriceCalculator {
		
		/**
		 * Constructor.
		 * 
		 * @param movement Movement thats toll needs to be calculated.
		 */
		public PriceCalculator(Movement movement) {
			this.movement = movement;
		}
		
		/**
		 * Calculate toll of the movement.
		 * 
		 * @return Toll of the movement using a look-up-table.
		 */
		public double calculatePrice() {
			if(movement.isOnMotorway() == true) {
				return lutMotorway[movement.getTruck().getEmissionCategory()][movement.getjCategory()] 
						* movement.getDistance();
			} else {
				return lutMainRoad[movement.getTruck().getEmissionCategory()][movement.getjCategory()] 
						* movement.getDistance();
			}
		}
		
		/**
		 * Look-up-table for calculating price in case of motorway.
		 * First dimension: J category
		 * Second dimension: Emission category
		 */
		private final double[][] lutMotorway = {
				{48.72, 68.36, 105.82},
				{57.32, 80.42, 124.49},
				{65.92, 92.48, 149.39}
		};
		
		/**
		 * Look-up-table for calculating price in case of main road.
		 * First dimension: J category
		 * Second dimension: Emission category
		 */
		private final double[][] lutMainRoad = {
				{20.72, 35.89, 66.00},
				{24.38, 42.22, 77.65},
				{28.04, 48.55, 93.18}
		};
		
		/**
		 * Movement thats toll needs to be calculated.
		 */
		private Movement movement;
	}
	
}
