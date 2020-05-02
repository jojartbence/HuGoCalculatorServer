package bme.jojartbence.model;

import java.util.Date;

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
	@ManyToOne
	Truck truck;
	@Column(columnDefinition = "DATETIME")
	Date timeFrom;
	@Column(columnDefinition = "DATETIME")
	Date timeTo;
	int distance;
	boolean onMotorway;
	
	private Movement() {}

	public Truck getTruck() {
		return truck;
	}

	public void setTruck(Truck truck) {
		this.truck = truck;
	}

	public Date getTimeFrom() {
		return timeFrom;
	}

	public void setTimeFrom(Date timeFrom) {
		this.timeFrom = timeFrom;
	}

	public Date getTimeTo() {
		return timeTo;
	}

	public void setTimeTo(Date timeTo) {
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