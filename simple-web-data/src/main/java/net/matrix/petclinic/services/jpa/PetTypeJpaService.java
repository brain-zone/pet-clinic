/**
 *
 */
package net.matrix.petclinic.services.jpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import net.matrix.petclinic.model.PetType;
import net.matrix.petclinic.repositories.PetTypeRepository;
import net.matrix.petclinic.services.PetTypeService;

/**
 * A Jpa implementation of {@link PetTypeService}.
 *
 * @author anand.hemadri
 *
 */
@Service
@Profile("springdatajpa")
public class PetTypeJpaService extends AbstractJpaService<PetType, PetTypeRepository> implements PetTypeService {

	/**
	 * Constructs a new instance of {@link PetTypeJpaService}.
	 *
	 * @param repository
	 */
	public PetTypeJpaService(PetTypeRepository repository) {
		super(repository);
	}
}
