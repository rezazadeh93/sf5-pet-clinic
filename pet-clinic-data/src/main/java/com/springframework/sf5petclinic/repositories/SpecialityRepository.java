package com.springframework.sf5petclinic.repositories;

import com.springframework.sf5petclinic.model.Speciality;
import org.springframework.data.repository.CrudRepository;

public interface SpecialityRepository extends CrudRepository<Speciality, Long> {
}
