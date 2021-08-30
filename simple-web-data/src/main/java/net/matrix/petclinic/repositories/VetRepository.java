/**
 *
 */
package net.matrix.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import net.matrix.petclinic.model.Veterinarian;

/**
 * Repository for {@link Veterinarian veterinarians}.
 *
 * @author anand.hemadri
 *
 */
public interface VetRepository extends CrudRepository<Veterinarian, Long> {

}
