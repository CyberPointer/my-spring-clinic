package com.my.spring.clinic.model.repositories;

import com.my.spring.clinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
