/**
 *
 */
package net.matrix.petclinic.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Models a {@link Pet pet's} {@link Visit visit} to the Pet Clinic.
 *
 * @author anand.hemadri
 *
 */
@Entity
@Table(name = "visits")
public class Visit extends BaseEntity {
	@Column(name = "description")
	private String description;

	@Column(name = "visit_date")
	private LocalDate visitDate;

	@ManyToOne
	@JoinColumn(name = "pet_id")
	private Pet pet;

	/**
	 * Constructs a new instance of {@link Visit}.
	 */
	public Visit() {

	}

	/**
	 * Constructs a new instance of {@link Visit},
	 *
	 * @param visitDate
	 * @param description
	 * @param pet
	 */
	public Visit(LocalDate visitDate, String description, Pet pet) {
		this.description = description;
		this.visitDate = visitDate;
		this.pet = pet;
	}

	/**
	 * Returns the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Returns the {@link Pet pet}.
	 *
	 * @return the pet
	 */
	public Pet getPet() {
		return pet;
	}

	/**
	 * Returns the visit date.
	 *
	 * @return the visit date
	 */
	public LocalDate getVisitDate() {
		return visitDate;
	}

	/**
	 * Assigns the description.
	 *
	 * @param description the description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Assigns the {@link Pet pet}.
	 *
	 * @param pet the pet
	 */
	public void setPet(Pet pet) {
		this.pet = pet;
	}

	/**
	 * Assigns the visit date.
	 *
	 * @param visitDate the visit date
	 */
	public void setVisitDate(LocalDate visitDate) {
		this.visitDate = visitDate;
	}
}
