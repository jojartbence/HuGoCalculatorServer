package bme.jojartbence.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import bme.jojartbence.model.Movement;


/**
 * @author Bence Jójárt <jojart.bence96@gmail.com>
 * @version 1.0
 * @since 1.0
 * 
 * This class represents the database table of movements. Handled by spring framework.
 */
public interface MovementRepository extends CrudRepository<Movement, Long> {

	List<Movement> findAll();
}
