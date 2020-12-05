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
        ownerTemp.setFirstName("Alex");
        ownerTemp.setLastName("Vasquez");
        serviceOwner.save(ownerTemp);

        ownerTemp = new Owner();
        ownerTemp.setFirstName("Mike");
        ownerTemp.setLastName("Tyson");
        serviceOwner.save(ownerTemp);

        System.out.println("Owner Data loaded ...");

        Vet vetTemp = new Vet();
        vetTemp.setFirstName("LeBron");
        vetTemp.setLastName("James");
        serviceVet.save(vetTemp);

        vetTemp = new Vet();
        vetTemp.setFirstName("Tom");
        vetTemp.setLastName("Cruise");
        serviceVet.save(vetTemp);

        System.out.println("Vet Data loaded ...");
    }
}
