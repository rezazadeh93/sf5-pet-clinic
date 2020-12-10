package com.springframework.sf5petclinic.services.map;

import com.springframework.sf5petclinic.model.Speciality;
import com.springframework.sf5petclinic.model.Vet;
import com.springframework.sf5petclinic.services.ServiceSpeciality;
import com.springframework.sf5petclinic.services.ServiceVet;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ServiceMapVet extends AbstractMapService<Vet, Long> implements ServiceVet {
    private final ServiceSpeciality serviceSpeciality;

    public ServiceMapVet(ServiceSpeciality serviceSpeciality) {
        this.serviceSpeciality = serviceSpeciality;
    }

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
        if (object != null) {
            if (object.getSpecialities() != null) {
                object.getSpecialities().forEach(speciality -> {
                    if (speciality.getId() == null) {
                        Speciality savedSpc = serviceSpeciality.save(speciality);
                        speciality.setId(savedSpc.getId());
                    }
                });
            }

            return super.save(object);
        } else {
            throw new RuntimeException("Vet cannot be null");
        }
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
