package com.springframework.sf5petclinic.services.map;

import com.springframework.sf5petclinic.model.Pet;
import com.springframework.sf5petclinic.services.CrudService;

import java.util.Set;

public class ServiceMapPet extends AbstractMapService<Pet, Long> implements CrudService<Pet, Long> {
    @Override
    public Pet findByID(Long id) {
        return super.findByID(id);
    }

    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public Pet Save(Pet object) {
        return super.save(object.getId(), object);
    }

    @Override
    public void deleteByID(Long id) {
        super.deleteByID(id);
    }

    @Override
    public void delete(Pet object) {
        super.delete(object);
    }
}
