package com.my.spring.clinic.bootstrap;

import com.my.spring.clinic.model.Owner;
import com.my.spring.clinic.model.Pet;
import com.my.spring.clinic.model.PetType;
import com.my.spring.clinic.model.Vet;
import com.my.spring.clinic.model.services.OwnerService;
import com.my.spring.clinic.model.services.PetTypeService;
import com.my.spring.clinic.model.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("cat");
        PetType savedCatPetType = petTypeService.save(cat);
        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddress("123 Brickerel");
        owner1.setCity("Miami");
        owner1.setTelephone("1231231234");

        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedDogPetType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("Rosco");
        owner1.getPets().add(mikesPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Bob");
        owner2.setLastName("Builder");
        owner2.setAddress("avenue 15");
        owner2.setCity("miami");
        owner2.setTelephone("76675329");

        Pet bobPet = new Pet();
        bobPet.setOwner(owner2);
        bobPet.setName("Dosco");
        bobPet.setPetType(savedCatPetType);
        bobPet.setBirthDate(LocalDate.now());
        owner2.getPets().add(bobPet);

        ownerService.save(owner2);

        Owner owner3 = new Owner();
        owner3.setFirstName("Fiona");
        owner3.setLastName("Morning");
        owner3.setAddress("mondoga 23");
        owner3.setCity("chicago");
        owner3.setTelephone("22223333");

        Pet fionaPet = new Pet();
        fionaPet.setOwner(owner3);
        fionaPet.setName("Leszko");
        fionaPet.setPetType(savedCatPetType);
        fionaPet.setBirthDate(LocalDate.now());
        owner3.getPets().add(fionaPet);

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
