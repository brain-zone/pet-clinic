package net.matrix.petclinic.services;

import java.util.Set;

import net.matrix.petclinic.model.BaseEntity;

/**
 * An interface to provide generic data providers for the Pet Clinic.
 *
 * @author anand.hemadri
 * @param <T> the entity
 *
 */
public interface CrudService<T extends BaseEntity> {
	/**
	 * Delete the record.
	 *
	 * @param data the record
	 */
	void delete(T data);

	/**
	 * Find all records.
	 *
	 * @return all records.
	 */
	Set<T> findAll();

	/**
	 * Find a record by id.
	 *
	 * @param id
	 * @return the record.
	 * @throws EntityNotFoundException when a matching record is not found
	 */
	T findById(Long id) throws EntityNotFoundException;

	/**
	 * Save the record.
	 *
	 * @param data the record
	 * @return the record
	 */
	T save(T data);
}
