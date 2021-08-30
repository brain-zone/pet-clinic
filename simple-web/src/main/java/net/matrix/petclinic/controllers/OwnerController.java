package net.matrix.petclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import net.matrix.petclinic.model.Owner;
import net.matrix.petclinic.model.Pet;
import net.matrix.petclinic.services.OwnerService;

/**
 * A controller to handle requests for {@link Pet pet} {@link Owner owners}.
 *
 * @author anand.hemadri
 *
 */
@Controller
@RequestMapping({"owners", "owners.html"})
public class OwnerController {
    private final OwnerService ownerService;

    /**
     * Constructs a new instance of {@link OwnerController}
     *
     * @param ownerService
     */
    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    /**
     * Searches the list of owners.
     *
     * @return the result page
     */
    @RequestMapping("/find")
    public String findOwners() {
        return "notimplemented";
    }

    /**
     * Return the list of {@link Owner owners}.
     *
     * @param model the model
     * @return the result page
     */
    @RequestMapping("")
    public String listOwners(Model model) {
        model.addAttribute("owners", ownerService.findAll());
        return "owners/index";
    }
}
