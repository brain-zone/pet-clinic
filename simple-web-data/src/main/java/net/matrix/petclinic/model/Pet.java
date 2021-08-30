package net.matrix.petclinic.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Models a {@link Pet pet}.
 *
 * @author anand.hemadri
 *
 */
@Entity
@Table(name = "pets")
public class Pet extends NamedEntity {
	@ManyToOne
	@JoinColumn(name = "owner_id")
	private Owner owner;

	@ManyToOne
	@JoinColumn(name = "type_id")
	private PetType petType;

	@Column(name = "birth_date")
	private LocalDate birthDate;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pet")
	private Set<Visit> visits = new HashSet<>();

	/**
	 * Returns the birth day.
	 *
	 * @return the birthDate
	 */
	public LocalDate getBirthDate() {
		return birthDate;
	}

	/**
	 * Returns the {@link Owner}.
	 *
	 * @return the owner
	 */
	public Owner getOwner() {
		return owner;
	}

	/**
	 * Returns the {@link PetType}
	 *
	 * @return the petType
	 */
	public PetType getPetType() {
		return petType;
	}

	/**
	 * Assigns the birth day.
	 *
	 * @param birthDate the birth day
	 */
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	/**
	 * Assigns the {@link Owner}.
	 *
	 * @param owner the owner to set
	 */
	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	/**
	 * Assigns the {@link PetType pet type}.
	 *
	 * @param petType the pet type
	 */
	public void setPetType(PetType petType) {
		this.petType = petType;
	}
}
