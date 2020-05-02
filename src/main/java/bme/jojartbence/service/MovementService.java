package bme.jojartbence.service;

import java.util.List;
import java.util.Timer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import bme.jojartbence.model.Movement;
import bme.jojartbence.repository.MovementRepository;

@Service
public class MovementService {
	
	@Autowired
	private ApplicationContext applicationContext;

	@Autowired
	private MovementRepository movementRepo;
	
	public List<Movement> getAllMovements() {
		return movementRepo.findAll();
	}
	
	public Movement addMovement(Movement movement) {
		
		MovementWatcher movementWatcher = applicationContext.getBean(MovementWatcher.class);
		movementWatcher.setMovement(movement);
		
		Timer timer = new Timer();
		timer.schedule(movementWatcher, movement.getTimeTo());
		
		return movementRepo.save(movement);
	}
	
	public void deleteMovement(Movement movement) {
		movementRepo.delete(movement);
	}
}
