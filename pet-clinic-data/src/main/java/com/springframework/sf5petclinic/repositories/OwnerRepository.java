package com.springframework.sf5petclinic.repositories;

import com.springframework.sf5petclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
    Optional<Owner> findByLastName(String lastName);
}
