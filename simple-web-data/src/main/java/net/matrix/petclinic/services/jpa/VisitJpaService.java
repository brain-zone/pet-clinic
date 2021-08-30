package net.matrix.petclinic.services.jpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import net.matrix.petclinic.model.Visit;
import net.matrix.petclinic.repositories.VisitRepository;
import net.matrix.petclinic.services.VisitService;

/**
 * A Jpa implementation of {@link VisitService}.
 *
 * @author anand.hemadri
 *
 */
@Service
@Profile("springdatajpa")
public class VisitJpaService extends AbstractJpaService<Visit, VisitRepository> implements VisitService {

	/**
	 * Constructs a new instance of {@link VisitJpaService}.
	 *
	 * @param repository
	 */
	public VisitJpaService(VisitRepository repository) {
		super(repository);
	}
}
