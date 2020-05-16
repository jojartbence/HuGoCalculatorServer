package bme.jojartbence.model;


import javax.persistence.CascadeType;
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
	private Truck truck;
	private long timeFrom;
	private long timeTo;
	private int distance;
	private boolean onMotorway;
	
	/**
	 * Vehicle category based on number of axles.
	 * 0: J2 - two axles
	 * 1: J3 - three axles
	 * 2: J4 - four or more axles
	 */
	private int jCategory;
	
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

	public int getjCategory() {
		return jCategory;
	}

	public void setjCategory(int jCategory) {
		this.jCategory = jCategory;
	}
}