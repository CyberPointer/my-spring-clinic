package com.my.spring.clinic.model.repositories;

import com.my.spring.clinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
