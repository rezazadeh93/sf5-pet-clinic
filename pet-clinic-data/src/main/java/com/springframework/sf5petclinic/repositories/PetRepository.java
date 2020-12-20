package com.springframework.sf5petclinic.repositories;

import com.springframework.sf5petclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
