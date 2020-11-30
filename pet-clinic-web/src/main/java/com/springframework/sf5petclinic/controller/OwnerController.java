package com.springframework.sf5petclinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/owners")
@Controller
public class OwnerController {
    @RequestMapping({"", "/", "index", "index.html"})
    public String ownersList() {
        return "owners/index";
    }
}