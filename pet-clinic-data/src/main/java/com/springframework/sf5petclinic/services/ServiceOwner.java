package com.springframework.sf5petclinic.services;

import com.springframework.sf5petclinic.model.Owner;

public interface ServiceOwner extends ServiceCrud<Owner, Long> {
    Owner findByLastName(String lastName);

}
