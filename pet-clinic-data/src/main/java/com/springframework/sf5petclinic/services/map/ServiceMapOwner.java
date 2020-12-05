package com.springframework.sf5petclinic.services.map;

import com.springframework.sf5petclinic.model.Owner;
import com.springframework.sf5petclinic.services.ServiceOwner;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ServiceMapOwner extends AbstractMapService<Owner, Long> implements ServiceOwner {
    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }

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
    public Owner save(Owner object) {
        return super.save(object);
    }
}
