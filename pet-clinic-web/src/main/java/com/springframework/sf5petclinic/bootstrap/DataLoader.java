package com.springframework.sf5petclinic.bootstrap;

import com.springframework.sf5petclinic.model.Owner;
import com.springframework.sf5petclinic.model.Vet;
import com.springframework.sf5petclinic.services.ServiceOwner;
import com.springframework.sf5petclinic.services.ServiceVet;
import com.springframework.sf5petclinic.services.map.ServiceMapOwner;
import com.springframework.sf5petclinic.services.map.ServiceMapVet;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class DataLoader implements CommandLineRunner {
    private final ServiceMapOwner serviceMapOwner;
    private final ServiceMapVet serviceMapVet;

    public DataLoader() {
        this.serviceMapOwner = new ServiceMapOwner();
        this.serviceMapVet = new ServiceMapVet();
    }

    @Override
    public void run(String... args) throws Exception {
        Owner ownerTemp = new Owner();
        ownerTemp.setId(1L);
        ownerTemp.setFirstName("Alex");
        ownerTemp.setLastName("Vasquez");
        serviceMapOwner.save(ownerTemp);

        ownerTemp = new Owner();
        ownerTemp.setId(2L);
        ownerTemp.setFirstName("Mike");
        ownerTemp.setLastName("Tyson");
        serviceMapOwner.save(ownerTemp);

        Vet vetTemp = new Vet();
        vetTemp.setId(1L);
        vetTemp.setFirstName("LeBron");
        vetTemp.setLastName("James");
        serviceMapVet.save(vetTemp);

        vetTemp = new Vet();
        vetTemp.setId(2L);
        vetTemp.setFirstName("Tom");
        vetTemp.setLastName("Cruise");
        serviceMapVet.save(vetTemp);
        
        System.out.println("Data loaded ...");
    }
}
