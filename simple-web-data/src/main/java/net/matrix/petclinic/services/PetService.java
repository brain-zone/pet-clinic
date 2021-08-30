/**
 *
 */
package net.matrix.petclinic.services;

import net.matrix.petclinic.model.Pet;

/**
 * An implementation of {@link CrudService} for {@link Pet}.
 *
 * @author anand.hemadri
 *
 */
public interface PetService extends CrudService<Pet> {
	/**
	 * Search by name of the {@link Pet}.
	 *
	 * @param name the name
	 * @return the pet
	 * @throws EntityNotFoundException when no matching {@link Pet pet} exists.
	 */
	public Pet findByName(String name) throws EntityNotFoundException;
}
