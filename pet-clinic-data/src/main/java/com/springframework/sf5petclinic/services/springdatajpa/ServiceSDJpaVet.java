package com.springframework.sf5petclinic.services.springdatajpa;

import com.springframework.sf5petclinic.model.Vet;
import com.springframework.sf5petclinic.repositories.SpecialityRepository;
import com.springframework.sf5petclinic.repositories.VetRepository;
import com.springframework.sf5petclinic.services.ServiceVet;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class ServiceSDJpaVet implements ServiceVet {
    private final VetRepository vetRepository;
    private final SpecialityRepository specialityRepository;

    public ServiceSDJpaVet(VetRepository vetRepository, SpecialityRepository specialityRepository) {
        this.vetRepository = vetRepository;
        this.specialityRepository = specialityRepository;
    }

    @Override
    public Vet findByID(Long aLong) {
        return vetRepository.findById(aLong).orElse(null);
    }

    @Override
    public Set<Vet> findAll() {
        Set<Vet> vets = new HashSet<>();
        vetRepository.findAll().forEach(vets::add);
        return vets;
    }

    @Override
    public Vet save(Vet object) {
        return vetRepository.save(object);
    }

    @Override
    public void deleteByID(Long aLong) {
        vetRepository.deleteById(aLong);
    }

    @Override
    public void delete(Vet object) {
        vetRepository.delete(object);
    }
}
