package com.springframework.sf5petclinic.repositories;

import com.springframework.sf5petclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
