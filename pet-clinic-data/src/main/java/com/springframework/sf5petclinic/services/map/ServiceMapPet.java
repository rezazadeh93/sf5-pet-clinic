package com.springframework.sf5petclinic.services.map;

import com.springframework.sf5petclinic.model.Pet;
import com.springframework.sf5petclinic.services.ServicePet;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ServiceMapPet extends AbstractMapService<Pet, Long> implements ServicePet {
    @Override
    public Pet findByID(Long id) {
        return super.findByID(id);
    }

    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public Pet save(Pet object) {
        return super.save(object);
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
