package net.matrix.petclinic.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import net.matrix.petclinic.model.Pet;

/**
 * Repository for {@link Pet pet}.
 *
 * @author anand.hemadri
 *
 */
public interface PetRepository extends CrudRepository<Pet, Long> {
	/**
	 * Search {@link Pet pet} by name.
	 *
	 * @param name the name
	 * @return Pet
	 */
	public Optional<Pet> findByName(String name);
}
