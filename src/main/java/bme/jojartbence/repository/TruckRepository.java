package bme.jojartbence.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import bme.jojartbence.model.Truck;


/**
 * @author Bence Jójárt <jojart.bence96@gmail.com>
 * @version 1.0
 * @since 1.0
 * 
 * This class represents the database table of trucks. Handled by spring framework.
 */
public interface TruckRepository extends CrudRepository<Truck, Long> {

	List<Truck> findAll();
}
