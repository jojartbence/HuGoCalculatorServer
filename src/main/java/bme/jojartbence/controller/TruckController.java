package bme.jojartbence.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import bme.jojartbence.model.Truck;
import bme.jojartbence.service.TruckService;


/**
 * @author Bence Jójárt <jojart.bence96@gmail.com>
 * @version 1.0
 * @since 1.0
 * 
 * This class handles REST HTTP requests related to trucks. Handled by spring framework.
 */
@RestController
public class TruckController {
	
	/**
	 * Service behind the controller.
	 */
	@Autowired
	TruckService truckService;
	
	/**
	 * This function is called when a HTTP GET request occurs to /truck/all.
	 * 
	 * @return List of all trucks in JSON format.
	 */
	@GetMapping("/truck/all")
	public List<Truck> getAllTrucks() {
		return truckService.getAllTrucks();
	}
	
	/**
	 * This function is called when a HTTP POST request occurs to /truck/add.
	 * 
	 * @param trcuk Truck object in JSON format
	 * @return Same truck object with an ID got from the database. 
	 */
	@PostMapping("/truck/add")
	@ResponseStatus(HttpStatus.CREATED)
	public Truck addMovement(@RequestBody Truck truck) {
		return truckService.addTruck(truck);
	}
}
