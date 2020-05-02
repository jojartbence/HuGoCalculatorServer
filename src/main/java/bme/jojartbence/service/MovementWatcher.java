package bme.jojartbence.service;


import java.util.TimerTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import bme.jojartbence.model.Movement;

@Service
@Scope(value="prototype", proxyMode=ScopedProxyMode.TARGET_CLASS)
public class MovementWatcher extends TimerTask {
	
	private Movement movement;
	
	public Movement getMovement() {
		return movement;
	}

	public void setMovement(Movement movement) {
		this.movement = movement;
	}

	@Autowired
	PaymentService paymentService;
	
	@Autowired
	MovementService movementService;
	
	public void run() {
		movementOverCallback();
	}
	
	void movementOverCallback() {
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
