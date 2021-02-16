package com.my.spring.clinic.bootstrap;


import com.my.spring.clinic.model.Owner;
import com.my.spring.clinic.model.Vet;
import com.my.spring.clinic.model.services.OwnerService;
import com.my.spring.clinic.model.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Bob");
        owner2.setLastName("Builder");

        ownerService.save(owner2);

        Owner owner3 = new Owner();
        owner3.setFirstName("Fiona");
        owner3.setLastName("Morning");

        ownerService.save(owner3);

        System.out.println("####### Loaded owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Micah");
        vet1.setLastName("Belle");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Arthur");
        vet2.setLastName("morgan");

        vetService.save(vet2);

        Vet vet3 = new Vet();
        vet3.setFirstName("Dutch");
        vet3.setLastName("van der linde");

        vetService.save(vet3);

        System.out.println("####### Loaded vets...");


    }
}
