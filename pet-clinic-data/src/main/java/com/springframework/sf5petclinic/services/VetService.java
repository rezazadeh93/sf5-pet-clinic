package com.springframework.sf5petclinic.services;

import com.springframework.sf5petclinic.model.Vet;

import java.util.Set;

public interface VetService {
    Vet findByID(Long ID);

    Vet save(Vet Vet);

    Set<Vet> findAll();
}
