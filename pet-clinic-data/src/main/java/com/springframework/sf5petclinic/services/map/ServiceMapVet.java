package com.springframework.sf5petclinic.services.map;

import com.springframework.sf5petclinic.model.Vet;
import com.springframework.sf5petclinic.services.ServiceVet;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ServiceMapVet extends AbstractMapService<Vet, Long> implements ServiceVet {
    @Override
    public Vet findByID(Long id) {
        return super.findByID(id);
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet save(Vet object) {
        return super.save(object);
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
