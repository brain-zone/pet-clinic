package net.matrix.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import net.matrix.petclinic.model.Pet;
import net.matrix.petclinic.model.Visit;

/**
 * Repository for {@link Pet pet} {@link Visit visits}.
 *
 * @author anand.hemadri
 *
 */
public interface VisitRepository extends CrudRepository<Visit, Long> {

}
