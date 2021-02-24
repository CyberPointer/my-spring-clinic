package com.my.spring.clinic.model.services.map;

import com.my.spring.clinic.model.Vet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class VetMapServiceTest {
    final Long vetId = 1l;

    VetMapService vetMapService;

    @BeforeEach
    void setUp() {
        vetMapService = new VetMapService(new SpecialityMapService());
        Vet tmpVet = new Vet();
        tmpVet.setId(vetId);
        vetMapService.save(tmpVet);

    }

    @Test
    void findAll() {
        Assertions.assertEquals(1,vetMapService.findAll().size());
    }

    @Test
    void deleteById() {
        vetMapService.deleteById(vetId);
        Assertions.assertEquals(0, vetMapService.findAll().size());
    }

    @Test
    void deleteByWrongId() {
        vetMapService.deleteById(vetId+1);
        Assertions.assertEquals(1, vetMapService.findAll().size());
    }

    @Test
    void delete() {
        vetMapService.delete(vetMapService.findById(vetId));
        Assertions.assertEquals(0,vetMapService.findAll().size());
    }

    @Test
    void deleteWrongObject() {
        vetMapService.delete(vetMapService.findById(vetId + 1));
        Assertions.assertEquals(1,vetMapService.findAll().size());
    }

    @Test
    void save() {
        vetMapService.save(new Vet());
        Assertions.assertEquals(2, vetMapService.findAll().size());
    }

    @Test
    void findById() {
        Vet foundedVet = vetMapService.findById(vetId);
        Assertions.assertEquals(vetId, foundedVet.getId());
    }
}