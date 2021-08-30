/**
 *
 */
package net.matrix.petclinic.services.map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import net.matrix.petclinic.model.Pet;
import net.matrix.petclinic.services.EntityNotFoundException;
import net.matrix.petclinic.services.PetService;

/**
 * An default repository implementation of {@link PetService}.
 *
 * @author anand.hemadri
 *
 */
@Service
@Profile({ "default", "map" })
public class PetMapService extends AbstractMapService<Pet> implements PetService {
	/**
	 * Constructs a new instance of {@link PetMapService}.
	 */
	public PetMapService() {
		super(new Pet());
	}

	@Override
	public Pet findByName(String name) throws EntityNotFoundException {
		return dataSet.entrySet().stream().filter(e -> e.getValue().getName().equals(name)).findFirst()
				.orElseThrow(() -> new EntityNotFoundException("Pet by name, \"" + name + "\"")).getValue();
	}

}
