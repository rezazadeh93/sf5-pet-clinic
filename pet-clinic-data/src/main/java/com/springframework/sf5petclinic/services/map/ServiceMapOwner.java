package com.springframework.sf5petclinic.services.map;

import com.springframework.sf5petclinic.model.Owner;
import com.springframework.sf5petclinic.model.Pet;
import com.springframework.sf5petclinic.model.PetType;
import com.springframework.sf5petclinic.services.ServiceOwner;
import com.springframework.sf5petclinic.services.ServicePet;
import com.springframework.sf5petclinic.services.ServicePetType;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ServiceMapOwner extends AbstractMapService<Owner, Long> implements ServiceOwner {
    private final ServicePet servicePet;
    private final ServicePetType servicePetType;

    public ServiceMapOwner(ServicePet servicePet, ServicePetType servicePetType) {
        this.servicePet = servicePet;
        this.servicePetType = servicePetType;
    }

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
        if (object != null) {
            if (object.getPets() != null) {
                object.getPets().forEach(pet -> {

                    // while saving pet in owner's, pet or petType doesnt have an ID
                    if (pet.getId() == null) {
                        Pet savedPet = servicePet.save(pet);
                        pet.setId(savedPet.getId());
                    }

                    if (pet.getPetType() != null) {
                        if (pet.getPetType().getId() == null) {
                            PetType savedPetType = servicePetType.save(pet.getPetType());
                            pet.setPetType(savedPetType);
                        }
                    } else {

                        throw new RuntimeException("PetType is required");
                    }
                });
            }

            return super.save(object);
        } else {

            throw new RuntimeException("Owner cannot be null");
        }
    }
}
