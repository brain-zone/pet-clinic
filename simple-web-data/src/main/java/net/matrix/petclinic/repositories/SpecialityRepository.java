
package net.matrix.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import net.matrix.petclinic.model.Speciality;

/**
 * Repository for {@link Speciality speciality}.
 *
 * @author anand.hemadri
 *
 */
public interface SpecialityRepository extends CrudRepository<Speciality, Long> {

}
