/**
 *
 */
package net.matrix.petclinic.services.map;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.matrix.petclinic.model.BaseEntity;
import net.matrix.petclinic.services.CrudService;

/**
 * An abstract implementation of in memory {@link CrudService}.
 *
 * @author anand.hemadri
 * @param <T> the {@link BaseEntity model implementation}.
 */
public abstract class AbstractMapService<T extends BaseEntity> implements CrudService<T> {
	private static final Logger LOGGER = LoggerFactory.getLogger(BaseEntity.class);
	protected final Map<Long, T> dataSet = new HashMap<>();
	private final T emptyEntity;

	protected AbstractMapService(T emptyEntity) {
		LOGGER.trace("AbstractMapService::ctor");
		this.emptyEntity = emptyEntity;
	}

	@Override
	public void delete(T data) {
		dataSet.entrySet().removeIf(e -> e.getValue().equals(data));
	}

	@Override
	public Set<T> findAll() {
		return Collections.unmodifiableSet(new HashSet<>(dataSet.values()));
	}

	@Override
	public T findById(Long id) {
		return dataSet.getOrDefault(id, emptyEntity);
	}

	private Long nextId() {
		return dataSet.keySet().isEmpty() ? 1L : Collections.max(dataSet.keySet()) + 1;
	}

	/**
	 * Save the entity with the given identity.
	 *
	 * @param data the data
	 * @return the data
	 */
	@Override
	public T save(T data) {
		if (data == null) {
			throw new IllegalArgumentException("Cannot save null data");
		}

		if (data.isNew()) {
			data.setId(nextId());
		}

		dataSet.put(data.getId(), data);
		return data;
	}
}
