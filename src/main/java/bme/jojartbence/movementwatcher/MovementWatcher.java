package bme.jojartbence.movementwatcher;


import java.util.TimerTask;

import bme.jojartbence.model.Movement;
import bme.jojartbence.service.MovementService;
import bme.jojartbence.service.PaymentService;


public class MovementWatcher extends TimerTask {

	public MovementWatcher(Movement movement, PaymentService paymentService, MovementService movementService) {
		super();
		this.movement = movement;
		this.paymentService = paymentService;
		this.movementService = movementService;
	}

	private Movement movement;

	PaymentService paymentService;
	
	MovementService movementService;
	
	public void run() {
		movementOverCallback();
	}
	
	void movementOverCallback() {
		System.out.println("Movement over: deleting from database & withdrawing money from balance");
		
		PriceCalculator calculator = new PriceCalculator(movement);
		
		paymentService.withdraw(calculator.calculatePrice());
		movementService.deleteMovement(movement);
	}
	
	
	private class PriceCalculator {
		
		public PriceCalculator(Movement movement) {
			this.movement = movement;
		}
		
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
		
		private Movement movement;
	}
	
}
