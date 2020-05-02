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

@RestController
public class MovementController {

	@Autowired
	MovementService movementService;
	
	
	@GetMapping("/movement/all")
	public List<Movement> getAllMovements() {
		return movementService.getAllMovements();
	}
	
	
	@PostMapping("/movement/add")
	@ResponseStatus(HttpStatus.CREATED)
	public Movement addMovement(@RequestBody Movement movement) {
		return movementService.addMovement(movement);
	}
}
