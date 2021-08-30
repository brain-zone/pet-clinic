package net.matrix.petclinic.services.jpa;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.springframework.data.repository.CrudRepository;

import net.matrix.petclinic.model.BaseEntity;
import net.matrix.petclinic.services.CrudService;
import net.matrix.petclinic.services.EntityNotFoundException;

/**
 * An abstract implementation of {@link CrudRepository} and {@link CrudService}
 *
 * @author anand.hemadri
 *
 * @param <T> the entity
 * @param <R> the entity repository
 */
public abstract class AbstractJpaService<T extends BaseEntity, R extends CrudRepository<T, Long>>
		implements CrudService<T> {
	protected R repository;

	/**
	 * Constructs a new instance of {@link AbstractJpaService}.
	 *
	 * @param repository the repository
	 */
	public AbstractJpaService(R repository) {
		this.repository = repository;
	}

	@Override
	public void delete(T data) {
		repository.delete(data);
	}

	@Override
	public Set<T> findAll() {
		Set<T> results = new HashSet<T>();
		repository.findAll().forEach(results::add);
		return Collections.unmodifiableSet(results);
	}

	@Override
	public T findById(Long id) throws EntityNotFoundException {
		return repository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Cannot find an entry with id: " + id));
	}

	@Override
	public T save(T data) {
		return repository.save(data);
	}
}
