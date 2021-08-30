/**
 *
 */
package net.matrix.petclinic.model;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Models a {@link Veterinarian veterinarian}.
 *
 * @author anand.hemadri
 *
 */
@Entity
@Table(name = "vets")
public class Veterinarian extends Person {
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "vet_specialities", joinColumns = @JoinColumn(name = "vet_id"), inverseJoinColumns = @JoinColumn(name = "speciality_id"))
	private Set<Speciality> specialty = new HashSet<>();

	/**
	 * Add a {@link Speciality speciality} to {@link Veterinarian veterinarian}.
	 *
	 * @param speciality the name of the speciality
	 */
	public void addSpeciality(Speciality speciality) {
		specialty.add(speciality);
	}

	/**
	 * Returns the collection of specialities.
	 *
	 * @return the speciality
	 */
	public Collection<Speciality> getSpeciality() {
		return Collections.unmodifiableCollection(specialty);
	}
}
