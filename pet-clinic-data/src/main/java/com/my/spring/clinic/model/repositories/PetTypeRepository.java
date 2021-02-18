package com.my.spring.clinic.model.repositories;

import com.my.spring.clinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
