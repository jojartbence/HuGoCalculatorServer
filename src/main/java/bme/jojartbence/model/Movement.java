package bme.jojartbence.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name="movements")
public class Movement {

	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private Long id;
	@ManyToOne(cascade = {CascadeType.MERGE})
	Truck truck;
	long timeFrom;
	long timeTo;
	int distance;
	boolean onMotorway;
	
	private Movement() {}

	public Truck getTruck() {
		return truck;
	}

	public void setTruck(Truck truck) {
		this.truck = truck;
	}

	public long getTimeFrom() {
		return timeFrom;
	}

	public void setTimeFrom(long timeFrom) {
		this.timeFrom = timeFrom;
	}

	public long getTimeTo() {
		return timeTo;
	}

	public void setTimeTo(long timeTo) {
		this.timeTo = timeTo;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public boolean isOnMotorway() {
		return onMotorway;
	}

	public void setOnMotorway(boolean onMotorway) {
		this.onMotorway = onMotorway;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}