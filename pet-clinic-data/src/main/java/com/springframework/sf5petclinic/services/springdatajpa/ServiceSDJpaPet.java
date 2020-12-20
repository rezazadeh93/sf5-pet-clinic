package com.springframework.sf5petclinic.services.springdatajpa;

import com.springframework.sf5petclinic.model.Pet;
import com.springframework.sf5petclinic.repositories.PetRepository;
import com.springframework.sf5petclinic.services.ServicePet;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class ServiceSDJpaPet implements ServicePet {
    private final PetRepository petRepository;

    public ServiceSDJpaPet(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public Pet findByID(Long aLong) {
        return petRepository.findById(aLong).orElse(null);
    }

    @Override
    public Set<Pet> findAll() {
        Set<Pet> pets = new HashSet<>();
        petRepository.findAll().forEach(pets::add);
        return pets;
    }

    @Override
    public Pet save(Pet object) {
        return petRepository.save(object);
    }

    @Override
    public void deleteByID(Long aLong) {
        petRepository.deleteById(aLong);
    }

    @Override
    public void delete(Pet object) {
        petRepository.delete(object);
    }
}
