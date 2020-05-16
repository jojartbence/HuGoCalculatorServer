package bme.jojartbence.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bme.jojartbence.model.Truck;
import bme.jojartbence.repository.TruckRepository;
import bme.jojartbence.ui.TruckUiController;


/**
 * @author Bence Jójárt <jojart.bence96@gmail.com>
 * @version 1.0
 * @since 1.0
 * 
 * Service class for handling trucks.
 */
@Service
public class TruckService {

	/**
	 * DB repository behind the class.
	 */
	@Autowired
	private TruckRepository truckRepo;
	
	/**
	 * Java fx UI controller class to show trucks.
	 */
	@Autowired
	private TruckUiController uiController;

	/**
	 * This function returns all trucks.
	 * 
	 * @return list of all trucks.
	 */
	public List<Truck> getAllTrucks() {
		return truckRepo.findAll();
	}
	
	/**
	 * This function adds a truck to the database.
	 * It also refreshes java fx UI.
	 * 
	 * @param truck Truck to add.
	 * @return Truck with an ID received from the database.
	 */
	public Truck addTruck(Truck truck) {
		Truck newTruck = truckRepo.save(truck);
		uiController.refresh();
		return newTruck;
	}
}