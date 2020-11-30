package com.springframework.sf5petclinic.services.map;

import com.springframework.sf5petclinic.model.Vet;
import com.springframework.sf5petclinic.services.CrudService;

import java.util.Set;

public class ServiceMapVet extends AbstractMapService<Vet, Long> implements CrudService<Vet, Long> {
    @Override
    public Vet findByID(Long id) {
        return super.findByID(id);
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet Save(Vet object) {
        return super.save(object.getId(), object);
    }

    @Override
    public void deleteByID(Long id) {
        super.deleteByID(id);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }
}
