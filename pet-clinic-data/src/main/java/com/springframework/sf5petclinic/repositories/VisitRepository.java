package com.springframework.sf5petclinic.repositories;

import com.springframework.sf5petclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
