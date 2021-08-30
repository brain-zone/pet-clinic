/**
 *
 */
package net.matrix.petclinic.services.map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import net.matrix.petclinic.model.Visit;
import net.matrix.petclinic.services.VisitService;

/**
 * A default implementation of {@link VisitService}.
 *
 * @author anand.hemadri
 *
 */
@Service
@Profile({ "default", "map" })
public class VisitMapService extends AbstractMapService<Visit> implements VisitService {
	/**
	 * Constructs a new instance of {@link VisitMapService}.
	 */
	public VisitMapService() {
		super(new Visit());
	}

	@Override
	public Visit save(Visit visit) {
		if (visit.getPet() == null || visit.getPet().getOwner() == null || visit.getPet().getId() == null) {
			throw new RuntimeException("Invalid visit");
		}

		return super.save(visit);
	}
}
