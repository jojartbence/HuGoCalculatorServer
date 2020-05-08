package bme.jojartbence.service;

import java.util.List;
import java.util.Timer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bme.jojartbence.model.Movement;
import bme.jojartbence.repository.MovementRepository;
import bme.jojartbence.movementwatcher.MovementWatcher;

@Service
public class MovementService {
	
	@Autowired
	private MovementRepository movementRepo;
	
	@Autowired
	private PaymentService paymentService;
	
	public List<Movement> getAllMovements() {
		return movementRepo.findAll();
	}
	
	public Movement addMovement(Movement movement) {
		
		MovementWatcher watcher = new MovementWatcher(movement, paymentService, this);
			 		
		Timer timer = new Timer();
		timer.schedule(watcher, movement.getTimeTo());
				
		return movementRepo.save(movement);
	}
	
	public void deleteMovement(Movement movement) {
		movementRepo.delete(movement);
	}
}
