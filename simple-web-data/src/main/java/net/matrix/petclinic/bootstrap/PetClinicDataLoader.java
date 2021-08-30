/**
 *
 */
package net.matrix.petclinic.bootstrap;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import net.matrix.petclinic.model.Owner;
import net.matrix.petclinic.model.Pet;
import net.matrix.petclinic.model.PetType;
import net.matrix.petclinic.model.Speciality;
import net.matrix.petclinic.model.Veterinarian;
import net.matrix.petclinic.model.Visit;
import net.matrix.petclinic.services.OwnerService;
import net.matrix.petclinic.services.PetTypeService;
import net.matrix.petclinic.services.SpecialityService;
import net.matrix.petclinic.services.VetService;
import net.matrix.petclinic.services.VisitService;

/**
 * A boot strap implementation to load test data upon startup of the
 * application.
 *
 * @author anand.hemadri
 *
 */
@Component
@SuppressWarnings("javadoc")
public class PetClinicDataLoader implements CommandLineRunner {
	private final VetService vetService;
	private final OwnerService ownerService;
	private final PetTypeService petTypeService;
	private final SpecialityService specialityService;
	private final VisitService visitService;

	public PetClinicDataLoader(VetService vetService, OwnerService ownerService, PetTypeService petTypeService,
			SpecialityService specialityService, VisitService visitService) {
		this.vetService = vetService;
		this.ownerService = ownerService;
		this.petTypeService = petTypeService;
		this.specialityService = specialityService;
		this.visitService = visitService;
	}

	@Override
	public void run(String... args) throws Exception {
		if (ownerService.findAll().size() > 0) {
			return;
		}
		System.out
				.println("=======>>> Active Profile:" + System.getProperty("spring.profiles.active") + " <<<<=======");

		PetType dog = petTypeService.save(new PetType("Dog"));
		PetType cat = petTypeService.save(new PetType("Cat"));

		Speciality radiology = specialityService.save(new Speciality("Radiology"));
		Speciality surgery = specialityService.save(new Speciality("Surgery"));
//		Speciality dentistry = specialityRepository.save(new Speciality("dentistry"));

		Owner owner1 = new Owner();
		owner1.setFirstName("Michael");
		owner1.setLastName("Weston");
		owner1.setAddress("123 Brickerel");
		owner1.setCity("Miami");
		owner1.setTelephone("1231231234");

		Pet mikesPet = new Pet();
		mikesPet.setPetType(dog);
		mikesPet.setBirthDate(LocalDate.now());
		mikesPet.setName("mikesPet");
		mikesPet.setOwner(owner1);
		owner1.addPet(mikesPet);

		ownerService.save(owner1);

		Owner owner2 = new Owner();
		owner2.setFirstName("Fiona");
		owner2.setLastName("Glenanne");
		owner2.setAddress("123 Brickerel");
		owner2.setCity("Miami");
		owner2.setTelephone("1231231234");

		Pet fionasCat = new Pet();
		fionasCat.setName("fionasCat");
		fionasCat.setOwner(owner2);
		fionasCat.setBirthDate(LocalDate.now());
		fionasCat.setPetType(cat);
		owner2.addPet(fionasCat);

		ownerService.save(owner2);

		System.out.println("Loaded Owners....");

		Veterinarian vet1 = new Veterinarian();
		vet1.setFirstName("Sam");
		vet1.setLastName("Axe");
		vet1.addSpeciality(radiology);
		vetService.save(vet1);

		Veterinarian vet2 = new Veterinarian();
		vet2.setFirstName("Jessie");
		vet2.setLastName("Porter");
		vet2.addSpeciality(surgery);
		vetService.save(vet2);

		System.out.println("Loaded Vets....");

		Visit catVisit = new Visit();
		catVisit.setPet(fionasCat);
		catVisit.setVisitDate(LocalDate.now());
		catVisit.setDescription("Sneezy Cat");
		visitService.save(catVisit);

		System.out.println("Loaded visit...");
	}
}
