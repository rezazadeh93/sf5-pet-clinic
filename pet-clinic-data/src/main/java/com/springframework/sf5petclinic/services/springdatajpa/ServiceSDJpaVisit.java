package com.springframework.sf5petclinic.services.springdatajpa;

import com.springframework.sf5petclinic.model.Visit;
import com.springframework.sf5petclinic.repositories.VisitRepository;
import com.springframework.sf5petclinic.services.ServiceVisit;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class ServiceSDJpaVisit implements ServiceVisit {
    private final VisitRepository visitRepository;

    public ServiceSDJpaVisit(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    @Override
    public Visit findByID(Long aLong) {
        return visitRepository.findById(aLong).orElse(null);
    }

    @Override
    public Set<Visit> findAll() {
        Set<Visit> visits = new HashSet<>();
        visitRepository.findAll().forEach(visits::add);
        return visits;
    }

    @Override
    public Visit save(Visit object) {
        return visitRepository.save(object);
    }

    @Override
    public void deleteByID(Long aLong) {
        visitRepository.deleteById(aLong);
    }

    @Override
    public void delete(Visit object) {
        visitRepository.delete(object);
    }
}
