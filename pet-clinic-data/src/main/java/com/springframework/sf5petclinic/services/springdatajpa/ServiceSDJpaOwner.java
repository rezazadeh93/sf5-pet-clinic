package com.springframework.sf5petclinic.services.springdatajpa;

import com.springframework.sf5petclinic.model.Owner;
import com.springframework.sf5petclinic.repositories.OwnerRepository;
import com.springframework.sf5petclinic.repositories.PetRepository;
import com.springframework.sf5petclinic.repositories.PetTypeRepository;
import com.springframework.sf5petclinic.services.ServiceOwner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class ServiceSDJpaOwner implements ServiceOwner {
    private final OwnerRepository ownerRepository;
    private final PetRepository petRepository;
    private final PetTypeRepository petTypeRepository;

    public ServiceSDJpaOwner(OwnerRepository ownerRepository, PetRepository petRepository,
                             PetTypeRepository petTypeRepository) {
        this.ownerRepository = ownerRepository;
        this.petRepository = petRepository;
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Owner findByLastName(String lastName) {
        return ownerRepository.findByLastName(lastName).orElse(null);
    }

    @Override
    public Owner findByID(Long aLong) {
        return ownerRepository.findById(aLong).orElse(null);
    }

    @Override
    public Set<Owner> findAll() {
        Set<Owner> owners = new HashSet<>();
        ownerRepository.findAll().forEach(owners::add);
        return owners;
    }

    @Override
    public Owner save(Owner object) {
        return ownerRepository.save(object);
    }

    @Override
    public void deleteByID(Long aLong) {
        ownerRepository.deleteById(aLong);
    }

    @Override
    public void delete(Owner object) {
        ownerRepository.delete(object);
    }
}
