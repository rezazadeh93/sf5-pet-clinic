package com.springframework.sf5petclinic.services;

import com.springframework.sf5petclinic.model.Owner;

import java.util.Set;

public interface OwnerService {
    Owner findByLastName(String lastName);

    Owner findByID(Long ID);

    Owner save(Owner owner);

    Set<Owner> findAll();
}
