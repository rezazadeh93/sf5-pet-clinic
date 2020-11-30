package com.springframework.sf5petclinic.services;

import com.springframework.sf5petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {
    Owner findByLastName(String lastName);

}
