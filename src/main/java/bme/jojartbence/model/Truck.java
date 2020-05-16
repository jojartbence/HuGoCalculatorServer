package bme.jojartbence.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


/**
 * @author Bence Jójárt <jojart.bence96@gmail.com>
 * @version 1.0
 * @since 1.0
 * 
 * This class represents a truck entity.
 */
@Entity(name="trucks")
public class Truck {
		
	/**
	 * Auto-generated ID. Key in the database.
	 */
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private Long id;
	
	/**
	 * License plate number in the following format: ABC-123
	 */
	private String licensePlateNumber;
	
	/**
	 * EURO emission category of the truck.
	 * 0: >= EURO V
	 * 1: EURO II - EURO IV
	 * 2: <= EURO I
	 */
	private int emissionCategory;
	
	@OneToMany(mappedBy = "truck")
	private List<Movement> movements;
	
	private Truck() {}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLicensePlateNumber() {
		return licensePlateNumber;
	}
	public void setLicensePlateNumber(String licensePlateNumber) {
		this.licensePlateNumber = licensePlateNumber;
	}

	public int getEmissionCategory() {
		return emissionCategory;
	}

	public void setEmissionCategory(int emissionCategory) {
		this.emissionCategory = emissionCategory;
	}
}
