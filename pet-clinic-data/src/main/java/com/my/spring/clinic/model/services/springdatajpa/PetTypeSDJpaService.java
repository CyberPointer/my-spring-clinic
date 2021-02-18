package com.my.spring.clinic.model.services.springdatajpa;

import com.my.spring.clinic.model.PetType;
import com.my.spring.clinic.model.repositories.PetTypeRepository;
import com.my.spring.clinic.model.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;


@Service
@Profile("springdatajpa")
public class PetTypeSDJpaService implements PetTypeService {
   private final PetTypeRepository petTypeRepository;

    public PetTypeSDJpaService(PetTypeRepository petTypeRepository) {
        this.petTypeRepository = petTypeRepository;
    }


    @Override
    public Set<PetType> findAll() {
        Set<PetType> petTypes = new HashSet<>();
        petTypeRepository.findAll().forEach(petTypes::add);
        return petTypes;
    }

    @Override
    public PetType findById(Long aLong) {
        return null;
    }

    @Override
    public PetType save(PetType object) {
        return null;
    }

    @Override
    public void delete(PetType object) {

    }

    @Override
    public void deleteById(Long aLong) {

    }
}
