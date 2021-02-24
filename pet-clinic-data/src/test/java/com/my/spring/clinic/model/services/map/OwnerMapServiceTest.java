package com.my.spring.clinic.model.services.map;

import com.my.spring.clinic.model.Owner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

class OwnerMapServiceTest {

    OwnerMapService ownerMapService;

    final Long ownerId1 = 1l;
    final String ownerName = "smith";

    @BeforeEach
    void setUp() {
        ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());

        ownerMapService.save(Owner.builder().id(ownerId1).lastName(ownerName).build());

    }

    @Test
    void findAll() {
        Set<Owner> ownerSet =  ownerMapService.findAll();
        Assertions.assertEquals(1, ownerSet.size());

    }

    @Test
    void findById() {
        Owner owner = ownerMapService.findById(ownerId1);
        Assertions.assertEquals(ownerId1, owner.getId());
    }

    @Test
    void saveExistingId() {
        Long id = 2L;

        Owner owner2 = Owner.builder().id(id).build();
        Owner saveOwner = ownerMapService.save(owner2);

        Assertions.assertEquals(id, saveOwner.getId());
    }

    @Test
    void noId(){
        Owner savedOwner = ownerMapService.save(Owner.builder().build());
        Assertions.assertNotNull(savedOwner);
        Assertions.assertNotNull(savedOwner.getId());

    }


    @Test
    void deleteById() {
        ownerMapService.deleteById(ownerMapService.findById(ownerId1).getId());
        Assertions.assertEquals(0, ownerMapService.findAll().size());

    }

    @Test
    void delete() {
        ownerMapService.delete(ownerMapService.findById(ownerId1));
        Assertions.assertEquals(0, ownerMapService.findAll().size());
    }



    @Test
    void findByLastName() {
       Owner smith = ownerMapService.findByLastName(ownerName);
       Assertions.assertNotNull(smith);
       Assertions.assertEquals(ownerName, smith.getLastName());
    }

    @Test
    void findByLastNameNotFound() {
        Owner smith = ownerMapService.findByLastName("dzesi");
        Assertions.assertNull(smith);
    }

}