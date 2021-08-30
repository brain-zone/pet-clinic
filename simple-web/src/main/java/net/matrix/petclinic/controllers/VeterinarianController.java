/**
 *
 */
package net.matrix.petclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import net.matrix.petclinic.model.Veterinarian;
import net.matrix.petclinic.services.VetService;

/**
 * A controller to handle requests for {@link Veterinarian veterinarians}.
 *
 * @author anand.hemadri
 *
 */
@Controller
@RequestMapping("/vets.html")
public class VeterinarianController {
	private final VetService VetService;

	/**
	 * Constructs a new instance of {@link VeterinarianController}.
	 *
	 * @param VetService
	 */
	public VeterinarianController(VetService VetService) {
		this.VetService = VetService;
	}

	/**
	 * Returns the list of {@link Veterinarian veterinarians}.
	 *
	 * @param model
	 * @return the list of veterinarians
	 */
	@RequestMapping("")
	public String listVeterinarians(Model model) {
		model.addAttribute("title", "Vets listing...");
		model.addAttribute("vets", VetService.findAll());
		return "vets/index";
	}
}
