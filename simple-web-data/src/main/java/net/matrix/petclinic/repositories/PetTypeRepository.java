/**
 *
 */
package net.matrix.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import net.matrix.petclinic.model.PetType;

/**
 * Repository for {@link PetType pet type}.
 *
 * @author anand.hemadri
 *
 */
public interface PetTypeRepository extends CrudRepository<PetType, Long> {

}
