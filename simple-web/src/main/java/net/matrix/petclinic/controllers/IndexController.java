package net.matrix.petclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * The Index page controller.
 *
 * @author anand.hemadri
 *
 */
@Controller
public class IndexController {
	/**
	 * Returns the index page template.
	 * 
	 * @param model the model
	 * @return the index
	 */
	@RequestMapping({ "/", "", "index", "index.html" })
	public String indexPage(Model model) {
		model.addAttribute("header", "Pet Clinic index page");
		return "index";
	}
}
