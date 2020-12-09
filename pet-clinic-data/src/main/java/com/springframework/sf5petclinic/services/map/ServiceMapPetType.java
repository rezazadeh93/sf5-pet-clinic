package com.springframework.sf5petclinic.services.map;

import com.springframework.sf5petclinic.model.PetType;
import com.springframework.sf5petclinic.services.ServicePetType;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ServiceMapPetType extends AbstractMapService<PetType, Long> implements ServicePetType {
    @Override
    public PetType findByID(Long id) {
        return super.findByID(id);
    }

    @Override
    public Set<PetType> findAll() {
        return super.findAll();
    }

    @Override
    public PetType save(PetType object) {
        return super.save(object);
    }

    @Override
    public void deleteByID(Long id) {
        super.deleteByID(id);
    }

    @Override
    public void delete(PetType object) {
        super.delete(object);
    }
}
