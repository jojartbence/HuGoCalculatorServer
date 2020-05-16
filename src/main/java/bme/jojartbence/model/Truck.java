package bme.jojartbence.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name="trucks")
public class Truck {
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private Long id;
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
