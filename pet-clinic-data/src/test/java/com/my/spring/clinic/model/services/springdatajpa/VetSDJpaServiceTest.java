package com.my.spring.clinic.model.services.springdatajpa;

import com.my.spring.clinic.model.Vet;
import com.my.spring.clinic.model.repositories.VetRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;



@ExtendWith(MockitoExtension.class)
class VetSDJpaServiceTest {
    @Mock
    VetRepository vetRepository;

    @InjectMocks
    VetSDJpaService service;

    Set<Vet> returnVets;
    Vet vet1;

    @BeforeEach
    void setUp() {
        returnVets = new HashSet<>();
        vet1 = new Vet();
        vet1.setId(1l);
        returnVets.add(vet1);
        returnVets.add(new Vet());

    }

    @Test
    void findAll() {
        Mockito.when(vetRepository.findAll()).thenReturn(returnVets);

        Set<Vet> returnedVets = service.findAll();
        Assertions.assertEquals(2, returnVets.size());

    }

    @Test
    void findById() {

        Mockito.when(vetRepository.findById(ArgumentMatchers.anyLong())).thenReturn(Optional.of(vet1));

        Vet returnedVet = service.findById(1l);

        Assertions.assertEquals(returnedVet.getId(), 1l);
    }

    @Test
    void save() {
        Mockito.when(vetRepository.save(ArgumentMatchers.any())).thenReturn(vet1);

        Vet savedVet = service.save(vet1);

        Assertions.assertEquals(savedVet.getId(), vet1.getId());
    }

    @Test
    void delete() {
        service.delete(vet1);

        Mockito.verify(vetRepository).delete(ArgumentMatchers.any());
    }

    @Test
    void deleteById() {
        service.deleteById(vet1.getId());
        Mockito.verify(vetRepository).deleteById(ArgumentMatchers.anyLong());
    }
}