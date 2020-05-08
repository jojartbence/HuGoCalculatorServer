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
		System.out.println("TORLEEES\n");
		
		double unitPrice;
		
		if(movement.isOnMotorway() == true) {
			unitPrice = 20.72; 
		} else {
			unitPrice = 48.72;
		}
		
		paymentService.withdraw(movement.getDistance()*unitPrice);
		movementService.deleteMovement(movement);
	}
	
}
