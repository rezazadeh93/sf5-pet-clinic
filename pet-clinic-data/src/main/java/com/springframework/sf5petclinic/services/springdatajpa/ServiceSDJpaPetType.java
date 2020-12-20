package com.springframework.sf5petclinic.services.springdatajpa;

import com.springframework.sf5petclinic.model.PetType;
import com.springframework.sf5petclinic.repositories.PetTypeRepository;
import com.springframework.sf5petclinic.services.ServicePetType;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class ServiceSDJpaPetType implements ServicePetType {
    private final PetTypeRepository petTypeRepository;

    public ServiceSDJpaPetType(PetTypeRepository petTypeRepository) {
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public PetType findByID(Long aLong) {
        return petTypeRepository.findById(aLong).orElse(null);
    }

    @Override
    public Set<PetType> findAll() {
        Set<PetType> petTypeSet = new HashSet<>();
        petTypeRepository.findAll().forEach(petTypeSet::add);
        return petTypeSet;
    }

    @Override
    public PetType save(PetType object) {
        return petTypeRepository.save(object);
    }

    @Override
    public void deleteByID(Long aLong) {
        petTypeRepository.deleteById(aLong);
    }

    @Override
    public void delete(PetType object) {
        petTypeRepository.delete(object);
    }
}
