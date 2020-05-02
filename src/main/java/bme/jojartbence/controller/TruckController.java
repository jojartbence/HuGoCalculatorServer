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

@RestController
public class TruckController {
	
	@Autowired
	TruckService truckService;
	
	
	@GetMapping("/truck/all")
	public List<Truck> getAllTrucks() {
		return truckService.getAllTrucks();
	}
	
	
	@PostMapping("/truck/add")
	@ResponseStatus(HttpStatus.CREATED)
	public Truck addMovement(@RequestBody Truck truck) {
		return truckService.addTruck(truck);
	}
}
