package com.springframework.sf5petclinic.services.springdatajpa;

import com.springframework.sf5petclinic.model.Owner;
import com.springframework.sf5petclinic.repositories.OwnerRepository;
import com.springframework.sf5petclinic.repositories.PetRepository;
import com.springframework.sf5petclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ServiceSDJpaOwnerTest {
    public static final String firstName = "Mohammad";
    public static final String LAST_NAME = "Smith";
    public static final Long LONG_ID = 1L;

    @Mock
    OwnerRepository ownerRepository;

    @Mock
    PetRepository petRepository;

    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks
    ServiceSDJpaOwner serviceOwner;

    Owner returnOwner;

    @BeforeEach
    void setUp() {
        returnOwner = Owner.builder().id(LONG_ID).lastName(LAST_NAME).build();
    }

    @Test
    void findByLastName() {
        when(ownerRepository.findByLastName(anyString())).thenReturn(Optional.of(returnOwner));

        Owner savedOwner = serviceOwner.findByLastName(LAST_NAME);

        verify(ownerRepository).findByLastName(LAST_NAME);

        assertEquals(LAST_NAME, savedOwner.getLastName());
    }

    @Test
    void findByID() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnOwner));

        Owner savedOwner = serviceOwner.findByID(LONG_ID);

        verify(ownerRepository).findById(LONG_ID);
        assertEquals(LONG_ID, savedOwner.getId());
    }

    @Test
    void notFoundById() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());

        Owner savedOwner = serviceOwner.findByID(LONG_ID);

        verify(ownerRepository).findById(LONG_ID);
        assertNull(savedOwner);
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = new HashSet<>();
        ownerSet.add(Owner.builder().id(1L).build());
        ownerSet.add(Owner.builder().id(2L).build());

        when(ownerRepository.findAll()).thenReturn(ownerSet);

        Set<Owner> allOwners = serviceOwner.findAll();

        verify(ownerRepository).findAll();
        assertEquals(2, allOwners.size());
    }

    @Test
    void save() {
        when(ownerRepository.save(any())).thenReturn(returnOwner);

        Owner ownerTemp = Owner.builder().firstName(firstName).build();
        Owner savedOwner = serviceOwner.save(ownerTemp);

        verify(ownerRepository).save(ownerTemp);
        assertNotNull(savedOwner);
    }

    @Test
    void deleteByID() {
        serviceOwner.deleteByID(LONG_ID);

        verify(ownerRepository).deleteById(LONG_ID);
    }

    @Test
    void delete() {
        serviceOwner.delete(returnOwner);

        verify(ownerRepository, times(1)).delete(returnOwner);
    }
}