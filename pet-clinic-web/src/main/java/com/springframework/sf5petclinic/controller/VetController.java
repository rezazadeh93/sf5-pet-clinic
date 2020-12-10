package com.springframework.sf5petclinic.controller;

import com.springframework.sf5petclinic.services.ServiceVet;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VetController {
    private final ServiceVet serviceVet;

    public VetController(ServiceVet serviceVet) {
        this.serviceVet = serviceVet;
    }

    @RequestMapping({"/vets", "/vets/index", "/vets/index.html", "vets.html"})
    public String vetList(Model model) {
        model.addAttribute("vets", serviceVet.findAll());

        return "vets/index";
    }
}
