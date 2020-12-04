package com.springframework.sf5petclinic.bootstrap;

import com.springframework.sf5petclinic.model.Owner;
import com.springframework.sf5petclinic.model.Vet;
import com.springframework.sf5petclinic.services.ServiceOwner;
import com.springframework.sf5petclinic.services.ServiceVet;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class DataLoader implements CommandLineRunner {
    private final ServiceOwner serviceOwner;
    private final ServiceVet serviceVet;

    public DataLoader(ServiceOwner serviceOwner, ServiceVet serviceVet) {
        this.serviceOwner = serviceOwner;
        this.serviceVet = serviceVet;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner ownerTemp = new Owner();
        ownerTemp.setId(1L);
        ownerTemp.setFirstName("Alex");
        ownerTemp.setLastName("Vasquez");
        serviceOwner.save(ownerTemp);

        ownerTemp = new Owner();
        ownerTemp.setId(2L);
        ownerTemp.setFirstName("Mike");
        ownerTemp.setLastName("Tyson");
        serviceOwner.save(ownerTemp);

        Vet vetTemp = new Vet();
        vetTemp.setId(1L);
        vetTemp.setFirstName("LeBron");
        vetTemp.setLastName("James");
        serviceVet.save(vetTemp);

        vetTemp = new Vet();
        vetTemp.setId(2L);
        vetTemp.setFirstName("Tom");
        vetTemp.setLastName("Cruise");
        serviceVet.save(vetTemp);

        System.out.println("Data loaded ...");
    }
}
