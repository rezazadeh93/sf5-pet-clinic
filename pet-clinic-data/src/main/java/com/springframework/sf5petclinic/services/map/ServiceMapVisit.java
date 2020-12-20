package com.springframework.sf5petclinic.services.map;

import com.springframework.sf5petclinic.model.Visit;
import com.springframework.sf5petclinic.services.ServiceVisit;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ServiceMapVisit extends AbstractMapService<Visit, Long> implements ServiceVisit {
    @Override
    public Visit findByID(Long id) {
        return super.findByID(id);
    }

    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Visit object) {
        super.delete(object);
    }

    @Override
    public void deleteByID(Long id) {
        super.deleteByID(id);
    }

    @Override
    public Visit save(Visit visit) {
        if (visit.getPet() == null || visit.getPet().getOwner() == null || visit.getPet().getId() == null ||
        visit.getPet().getOwner().getId() == null) {
            throw new RuntimeException("Invalid Visit Record");
        }

        return super.save(visit);
    }
}
