package net.matrix.petclinic.model;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Models a {@link PetType pet type}.
 *
 * @author anand.hemadri
 *
 */
@Entity
@Table(name = "types")
public class PetType extends NamedEntity {
	/**
	 * Constructs a new instance of {@link PetType}.
	 */
	public PetType() {
		this("");
	}

	/**
	 * Constructs a new instance of {@link PetType}.
	 *
	 * @param name
	 */
	public PetType(String name) {
		super(name);
	}
}
