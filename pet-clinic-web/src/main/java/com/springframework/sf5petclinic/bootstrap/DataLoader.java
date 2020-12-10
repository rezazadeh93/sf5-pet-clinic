package com.springframework.sf5petclinic.bootstrap;

import com.springframework.sf5petclinic.model.*;
import com.springframework.sf5petclinic.services.ServiceOwner;
import com.springframework.sf5petclinic.services.ServicePetType;
import com.springframework.sf5petclinic.services.ServiceSpeciality;
import com.springframework.sf5petclinic.services.ServiceVet;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


@Component
public class DataLoader implements CommandLineRunner {
    private final ServiceOwner serviceOwner;
    private final ServiceVet serviceVet;
    private final ServicePetType servicePetType;
    private final ServiceSpeciality serviceSpeciality;

    public DataLoader(ServiceOwner serviceOwner, ServiceVet serviceVet, ServicePetType servicePetType, ServiceSpeciality serviceSpeciality) {
        this.serviceOwner = serviceOwner;
        this.serviceVet = serviceVet;
        this.servicePetType = servicePetType;
        this.serviceSpeciality = serviceSpeciality;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = servicePetType.findAll().size();

        if (count == 0) {
            loadData();
        }
    }

    private void loadData() {
        PetType petTypeTemp = new PetType();
        petTypeTemp.setName("Dog");
        PetType savedPetTypeDog = servicePetType.save(petTypeTemp);

        petTypeTemp = new PetType();
        petTypeTemp.setName("Cat");
        PetType savedPetTypeCat = servicePetType.save(petTypeTemp);

        Owner ownerTemp = new Owner();
        ownerTemp.setFirstName("Alex");
        ownerTemp.setLastName("Vasquez");
        ownerTemp.setAddress("No 79, Vanaq sq.");
        ownerTemp.setCity("Tehran");
        ownerTemp.setTelephone("02166951594");

        Pet pet1 = new Pet();
        pet1.setName("Jessie");
        pet1.setPetType(savedPetTypeDog);
        pet1.setBirthDate(LocalDate.now());
        pet1.setOwner(ownerTemp);

        ownerTemp.getPets().add(pet1);
        // here must be different with instructor's code because, owner must have an id, i think
        Owner savedOwner1 = serviceOwner.save(ownerTemp);

        ownerTemp = new Owner();
        ownerTemp.setFirstName("Mike");
        ownerTemp.setLastName("Tyson");
        ownerTemp.setAddress("no 123, Malibu st.");
        ownerTemp.setCity("New York");
        ownerTemp.setTelephone("044 9933 2244");
        // here must be different with instructor's code because, owner must have an id, i think
        Owner savedOwner2 = serviceOwner.save(ownerTemp);

        Pet pet2 = new Pet();
        pet2.setName("Teddy");
        pet2.setPetType(savedPetTypeCat);
        pet2.setBirthDate(LocalDate.now());
        pet2.setOwner(savedOwner2);

        savedOwner2.getPets().add(pet2);
        savedOwner2 = serviceOwner.save(savedOwner2);

        System.out.println("Owner Data loaded ...");

        //  saving specialities repository
        Speciality spcRadiology = new Speciality();
        spcRadiology.setDescription("Radiology");
        spcRadiology = serviceSpeciality.save(spcRadiology);

        Speciality spcSurgery = new Speciality();
        spcSurgery.setDescription("Surgery");
        spcSurgery = serviceSpeciality.save(spcSurgery);

        Speciality spcDentistry = new Speciality();
        spcDentistry.setDescription("Dentistry");
        spcDentistry = serviceSpeciality.save(spcDentistry);


        Vet vetTemp = new Vet();
        vetTemp.setFirstName("LeBron");
        vetTemp.setLastName("James");
        vetTemp.getSpecialities().add(spcRadiology);
        serviceVet.save(vetTemp);

        vetTemp = new Vet();
        vetTemp.setFirstName("Tom");
        vetTemp.setLastName("Cruise");
        vetTemp.getSpecialities().add(spcSurgery);
        serviceVet.save(vetTemp);

        System.out.println("Vet Data loaded ...");
    }
}
