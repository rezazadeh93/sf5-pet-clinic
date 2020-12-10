package com.springframework.sf5petclinic.services.map;

import com.springframework.sf5petclinic.model.Speciality;
import com.springframework.sf5petclinic.services.ServiceSpecialities;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ServiceMapSpecialities extends AbstractMapService<Speciality, Long> implements ServiceSpecialities {
    @Override
    public Speciality findByID(Long id) {
        return super.findByID(id);
    }

    @Override
    public Set<Speciality> findAll() {
        return super.findAll();
    }

    @Override
    public Speciality save(Speciality object) {
        return super.save(object);
    }

    @Override
    public void deleteByID(Long id) {
        super.deleteByID(id);
    }

    @Override
    public void delete(Speciality object) {
        super.delete(object);
    }
}
