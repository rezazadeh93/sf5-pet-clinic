package com.springframework.sf5petclinic.services.map;

import com.springframework.sf5petclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ServiceMapOwnerTest {
    ServiceMapOwner serviceMapOwner;
    final Long longValue = 4L;
    final String jackie = "Jackie";

    @BeforeEach
    void setUp() {
        serviceMapOwner = new ServiceMapOwner(new ServiceMapPet(), new ServiceMapPetType());

        serviceMapOwner.save(Owner.builder().id(longValue).lastName(jackie).build());
    }

    @Test
    void findByLastName() {
        Owner ownerTemp = serviceMapOwner.findByLastName(jackie);

        assertNotNull(ownerTemp);
        assertEquals(longValue, ownerTemp.getId());
        assertEquals(jackie, ownerTemp.getLastName());
    }

    @Test
    void findByID() {
        Owner ownerTemp = serviceMapOwner.findByID(longValue);

        assertEquals(longValue, ownerTemp.getId());
    }

    @Test
    void findAll() {
        Set<Owner> owners = serviceMapOwner.findAll();

        assertEquals(1, owners.size());
    }

    @Test
    void delete() {
        Owner ownerTemp = serviceMapOwner.findByID(longValue);
        serviceMapOwner.delete(ownerTemp);

        assertNull(serviceMapOwner.findByID(longValue));
        assertEquals(0, serviceMapOwner.findAll().size());
    }

    @Test
    void deleteByID() {
        serviceMapOwner.deleteByID(longValue);

        assertNull(serviceMapOwner.findByID(longValue));
        assertEquals(0, serviceMapOwner.findAll().size());
    }

    @Test
    void saveNoId() {
        String name = "Tim";
        Owner ownerTemp = Owner.builder().firstName(name).build();
        Owner savedOwner = serviceMapOwner.save(ownerTemp);

        assertNotNull(savedOwner.getId());
        assertEquals(name, savedOwner.getFirstName());
    }

    @Test
    void saveExistingId() {
        Long idValue = 2L;
        Owner ownerTemp = Owner.builder().id(idValue).build();
        Owner savedOwner = serviceMapOwner.save(ownerTemp);

        assertEquals(idValue, savedOwner.getId());
    }
}