package bme.jojartbence.service;

import java.util.Date;
import java.util.List;
import java.util.Timer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bme.jojartbence.model.Movement;
import bme.jojartbence.repository.MovementRepository;
import bme.jojartbence.movementwatcher.MovementWatcher;


/**
 * @author Bence Jójárt <jojart.bence96@gmail.com>
 * @version 1.0
 * @since 1.0
 * 
 * Service class for handling movements.
 */
@Service
public class MovementService {
	
	/**
	 * DB repository behind the class.
	 */
	@Autowired
	private MovementRepository movementRepo;
	
	/**
	 * Payment service that can be notified when a movement is over.
	 */
	@Autowired
	private PaymentService paymentService;
	
	/**
	 * This function returns all movements.
	 * 
	 * @return list of all movements.
	 */
	public List<Movement> getAllMovements() {
		return movementRepo.findAll();
	}
	
	/**
	 * This function adds a movement to the database.
	 * It also notifies payment service with the money to withdraw when the movement is over.
	 * 
	 * @param movement Movement to add.
	 * @return Movement with an ID received from the database.
	 */
	public Movement addMovement(Movement movement) {
		
		MovementWatcher watcher = new MovementWatcher(movement, paymentService, this);
			 		
		Timer timer = new Timer();
		timer.schedule(watcher, new Date(movement.getTimeTo()));
				
		return movementRepo.save(movement);
	}
	
	
	/**
	 * This function deletes a movement from the database.
	 * 
	 * @param movement Movement to delete.
	 */
	public void deleteMovement(Movement movement) {
		movementRepo.delete(movement);
	}
}
