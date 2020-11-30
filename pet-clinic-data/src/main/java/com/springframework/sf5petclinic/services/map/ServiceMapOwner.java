package com.springframework.sf5petclinic.services.map;

import com.springframework.sf5petclinic.model.Owner;
import com.springframework.sf5petclinic.services.CrudService;

import java.util.Set;

public class ServiceMapOwner extends AbstractMapService<Owner, Long> implements CrudService<Owner, Long> {

    @Override
    public Owner findByID(Long id) {
        return super.findByID(id);
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public void deleteByID(Long id) {
        super.deleteByID(id);
    }

    @Override
    public Owner Save(Owner object) {
        return super.save(object.getId(), object);
    }
}
