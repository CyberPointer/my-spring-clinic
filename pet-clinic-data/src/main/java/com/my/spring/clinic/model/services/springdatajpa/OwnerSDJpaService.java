package com.my.spring.clinic.model.services.springdatajpa;


import com.my.spring.clinic.model.Owner;
import com.my.spring.clinic.model.repositories.OwnerRepository;
import com.my.spring.clinic.model.repositories.PetRepository;
import com.my.spring.clinic.model.repositories.PetTypeRepository;
import com.my.spring.clinic.model.services.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class OwnerSDJpaService implements OwnerService {
    private final OwnerRepository ownerRepository;
    private final PetRepository petRepository;
    private final PetTypeRepository petTypeRepository;

    public OwnerSDJpaService(OwnerRepository ownerRepository, PetRepository petRepository,
                             PetTypeRepository petTypeRepository) {
        this.ownerRepository = ownerRepository;
        this.petRepository = petRepository;
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Owner findByLastName(String lastName) {
        return ownerRepository.findByLastName(lastName);
    }

    @Override
    public Set<Owner> findAll() {
       Set<Owner> owners = new HashSet<>();
       ownerRepository.findAll().forEach(owners::add);
       return  owners;

    }

    @Override
    public Owner findById(Long aLong) {
        return  ownerRepository.findById(aLong).orElse(null);
    }

    @Override
    public Owner save(Owner object) {
        return ownerRepository.save(object);
    }

    @Override
    public void delete(Owner object) {
        ownerRepository.delete(object);

    }

    @Override
    public void deleteById(Long aLong) {
        ownerRepository.deleteById(aLong);
    }
}
