package net.matrix.petclinic.model;

import javax.persistence.Entity;

/**
 * Models a {@link Veterinarian Veterinarian's} speciality.
 *
 * @author anand.hemadri
 *
 */
@Entity
public class Speciality extends NamedEntity {
	/**
	 * Constructs a new instance of {@link Speciality}.
	 */
	public Speciality() {
		this("");
	}

	/**
	 * Constructs a new instance of {@link Speciality}.
	 *
	 * @param name
	 */
	public Speciality(String name) {
		super(name);
	}

}
