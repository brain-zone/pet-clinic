package net.matrix.petclinic.model;

import javax.persistence.MappedSuperclass;

/**
 * Models an entity with a {@link NamedEntity name} for all {@link BaseEntity
 * base entities} in Pet Clinic application.
 *
 * @author anand.hemadri
 *
 */
@MappedSuperclass
public class NamedEntity extends BaseEntity {
	private String name;

	/**
	 * Constructs a new instance of {@link NamedEntity}.
	 * 
	 */
	public NamedEntity() {
	}

	/**
	 * Constructs a new instance of {@link NamedEntity} with a name.
	 * 
	 * @param name
	 */
	public NamedEntity(String name) {
		this.name = name;
	}

	/**
	 * Returns the name.
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Assigns the name.
	 * 
	 * @param name the name
	 */
	public void setName(String name) {
		this.name = name;
	}
}
