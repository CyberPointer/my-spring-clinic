package com.my.spring.clinic.model.services.map;

import com.my.spring.clinic.model.Pet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

class PetMapServiceTest {
   PetMapService petMapService;
    final Long petId = 1l;


    @BeforeEach
    void setUp() {
        petMapService = new PetMapService();
        Pet pet = new Pet();
        pet.setId(petId);
        petMapService.save(pet);
    }

    @Test
    void findAll() {
        Set<Pet> pets = petMapService.findAll();
        Assertions.assertEquals(1, pets.size());
    }

    @Test
    void save() {
        Long savedPetId = 2l;
        Pet savedPet = new Pet();
        savedPet.setId(savedPetId);
        petMapService.save(savedPet);
        Assertions.assertEquals(savedPetId, petMapService.findAll().size());

    }

    @Test
    void findById() {
        Pet foundedPet = petMapService.findById(petId);
        Assertions.assertNotNull(foundedPet);
        Assertions.assertEquals(petId, foundedPet.getId());

    }

    @Test
    void deleteById() {
        petMapService.deleteById(petId);
        Assertions.assertEquals(0,petMapService.findAll().size());
    }

    @Test
    void deleteByIdWrongId() {
        petMapService.deleteById(2L);
        Assertions.assertEquals(1,petMapService.findAll().size());
    }


    @Test
    void delete() {
        petMapService.delete(petMapService.findById(petId));
        Assertions.assertEquals(0, petMapService.findAll().size());

    }

    @Test
    void deleteWrongObject() {
        petMapService.delete(new Pet());
        Assertions.assertEquals(1, petMapService.findAll().size());

    }


}