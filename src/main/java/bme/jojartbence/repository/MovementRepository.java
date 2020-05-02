package bme.jojartbence.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import bme.jojartbence.model.Movement;

public interface MovementRepository extends CrudRepository<Movement, Long> {

	List<Movement> findAll();
}
