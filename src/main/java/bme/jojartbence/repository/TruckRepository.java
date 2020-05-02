package bme.jojartbence.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import bme.jojartbence.model.Truck;

public interface TruckRepository extends CrudRepository<Truck, Long> {

	List<Truck> findAll();
}
