package bme.jojartbence.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bme.jojartbence.model.Truck;
import bme.jojartbence.repository.TruckRepository;
import bme.jojartbence.ui.TruckUiController;

@Service
public class TruckService {

	@Autowired
	private TruckRepository truckRepo;
	
	@Autowired
	private TruckUiController uiController;

	public List<Truck> getAllTrucks() {
		return truckRepo.findAll();
	}
	
	public Truck addTruck(Truck truck) {
		Truck newTruck = truckRepo.save(truck);
		uiController.refresh();
		return newTruck;
	}
	
	public void deleteMovement(Truck truck) {
		truckRepo.delete(truck);
		uiController.refresh();
	}
}