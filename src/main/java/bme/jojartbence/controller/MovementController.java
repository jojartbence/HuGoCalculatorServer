package bme.jojartbence.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import bme.jojartbence.model.Movement;
import bme.jojartbence.service.MovementService;


/**
 * @author Bence Jójárt <jojart.bence96@gmail.com>
 * @version 1.0
 * @since 1.0
 * 
 * This class handles REST HTTP requests related to movements. Handled by spring framework.
 */
@RestController
public class MovementController {

	/**
	 * Service behind the controller.
	 */
	@Autowired
	MovementService movementService;
	
	/**
	 * This function is called when a HTTP GET request occurs to /movement/all.
	 * 
	 * @return List of all movement in JSON format.
	 */
	@GetMapping("/movement/all")
	public List<Movement> getAllMovements() {
		return movementService.getAllMovements();
	}
	
	/**
	 * This function is called when a HTTP POST request occurs to /movement/add.
	 * 
	 * @param movement Movement object in JSON format
	 * @return Same movement object with an ID got from the database. 
	 */
	@PostMapping("/movement/add")
	@ResponseStatus(HttpStatus.CREATED)
	public Movement addMovement(@RequestBody Movement movement) {
		return movementService.addMovement(movement);
	}
}
