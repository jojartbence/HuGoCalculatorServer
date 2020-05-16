package bme.jojartbence.model;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


/**
 * @author Bence Jójárt <jojart.bence96@gmail.com>
 * @version 1.0
 * @since 1.0
 * 
 * This class represents a movement entity.
 */
@Entity(name="movements")
public class Movement {

	/**
	 * Auto-generated ID. Key in the database.
	 */
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private Long id;
	
	/**
	 * Truck that owns the movement.
	 */
	@ManyToOne(cascade = {CascadeType.MERGE})
	private Truck truck;
	
	/**
	 * Movement from in millis.
	 */
	private long timeFrom;
	
	/**
	 * Movement to in millis.
	 */
	private long timeTo;
	
	/**
	 * Distance of movement in km.
	 */
	private int distance;
	
	/**
	 * True if movement happened on motorway. False if on main road.
	 */
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