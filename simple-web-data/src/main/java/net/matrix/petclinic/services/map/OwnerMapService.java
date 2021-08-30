/**
 *
 */
package net.matrix.petclinic.services.map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import net.matrix.petclinic.model.Owner;
import net.matrix.petclinic.model.Pet;
import net.matrix.petclinic.model.PetType;
import net.matrix.petclinic.services.EntityNotFoundException;
import net.matrix.petclinic.services.OwnerService;

/**
 * An default repository implementation of {@link OwnerService}.
 *
 * @author anand.hemadri
 *
 */
@Service
@Profile({"default", "map"})
public class OwnerMapService extends AbstractMapService<Owner> implements OwnerService {
    private final PetTypeMapService petTypeService;
    private final PetMapService petService;

    /**
     * Constructs a new instance of {@link OwnerMapService}.
     *
     * @param petTypeService the {PetTypeService pet type repository}
     * @param petService the {PetService pet repository}
     */
    public OwnerMapService(PetTypeMapService petTypeService, PetMapService petService) {
        super(new Owner());
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Owner findByLastName(String lastName) throws EntityNotFoundException {
        return dataSet.entrySet().stream().filter(e -> e.getValue().getLastName().equals(lastName)).findFirst()
                .orElseThrow(() -> new EntityNotFoundException("Search by last name:'" + lastName + "' did not yeild any results.")).getValue();
    }

    @Override
    public Owner save(Owner data) {
        if (data != null) {
            if (data.getPets() != null) {
                data.getPets().forEach(pet -> {
                    PetType petType = pet.getPetType();
                    if (petType != null) {
                        if (petType.isNew()) {
                            pet.setPetType(petTypeService.save(petType));
                        }
                    } else {
                        throw new IllegalArgumentException("Pet type is required.");
                    }

                    if (pet.isNew()) {
                        Pet savedPet = petService.save(pet);
                        pet.setId(savedPet.getId());
                    }
                });
            }
            return super.save(data);
        } else {
            throw new IllegalArgumentException("Cannot save null Owner data.");
        }
    }
}
