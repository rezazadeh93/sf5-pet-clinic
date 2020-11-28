package com.springframework.sf5petclinic.services;

import com.springframework.sf5petclinic.model.Pet;

import java.util.Set;

public interface PetService {
    Pet findByID(Long ID);

    Pet save(Pet Pet);

    Set<Pet> findAll();
}
