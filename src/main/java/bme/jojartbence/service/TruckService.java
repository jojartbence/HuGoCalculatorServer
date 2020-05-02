package bme.jojartbence.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bme.jojartbence.model.Truck;
import bme.jojartbence.repository.TruckRepository;

@Service
public class TruckService {
	
	@Autowired
	private TruckRepository truckRepo;

	public List<Truck> getAllTrucks() {
		return truckRepo.findAll();
	}
	
	public Truck addTruck(Truck truck) {
		return truckRepo.save(truck);
	}
	
	public void deleteMovement(Truck truck) {
		truckRepo.delete(truck);
	}
}