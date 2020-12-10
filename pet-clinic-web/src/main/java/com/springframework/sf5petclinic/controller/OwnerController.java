package com.springframework.sf5petclinic.controller;

import com.springframework.sf5petclinic.services.ServiceOwner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/owners")
@Controller
public class OwnerController {
    private final ServiceOwner serviceOwner;

    public OwnerController(ServiceOwner serviceOwner) {
        this.serviceOwner = serviceOwner;
    }

    @RequestMapping({"", "/", "index", "index.html"})
    public String ownersList(Model model) {
        model.addAttribute("owners", serviceOwner.findAll());

        return "owners/index";
    }

    @RequestMapping("/find")
    public String findOwners() {
        return "notImplemented";
    }
}
