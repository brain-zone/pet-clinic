package net.matrix.petclinic.services.map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import net.matrix.petclinic.model.Speciality;
import net.matrix.petclinic.services.SpecialityService;

/**
 * An default implementation of {@link SpecialityService}.
 *
 * @author anand.hemadri
 *
 */
@Service
@Profile({ "default", "map" })
public class SpecialityMapService extends AbstractMapService<Speciality> implements SpecialityService {
	/**
	 * Constructs a new instance of {@link SpecialityMapService}.
	 */
	public SpecialityMapService() {
		super(new Speciality());
	}
}
