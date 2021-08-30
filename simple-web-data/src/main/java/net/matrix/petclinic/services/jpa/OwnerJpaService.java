package net.matrix.petclinic.services.jpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import net.matrix.petclinic.model.Owner;
import net.matrix.petclinic.repositories.OwnerRepository;
import net.matrix.petclinic.repositories.PetRepository;
import net.matrix.petclinic.repositories.PetTypeRepository;
import net.matrix.petclinic.services.EntityNotFoundException;
import net.matrix.petclinic.services.OwnerService;

/**
 * A Jpa implementation of {@link OwnerService}.
 *
 * @author anand.hemadri
 *
 */
@Service
@Profile("springdatajpa")
public class OwnerJpaService extends AbstractJpaService<Owner, OwnerRepository> implements OwnerService {
    private PetRepository petRepository;
    private PetTypeRepository petTypeRepository;

    /**
     * Constructs a new instance of {@link OwnerJpaService}.
     *
     * @param ownerRepository the owner repository
     * @param petRepository the pet repository
     * @param petTypeRepository the pet type repository
     */
    public OwnerJpaService(OwnerRepository ownerRepository, PetRepository petRepository, PetTypeRepository petTypeRepository) {
        super(ownerRepository);
        this.petRepository = petRepository;
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Owner findByLastName(String lastName) throws EntityNotFoundException {
        return repository.findByLastName(lastName).orElseThrow(() -> new EntityNotFoundException("Search by last name: '" + lastName + "' resulted in no match."));
    }
}
