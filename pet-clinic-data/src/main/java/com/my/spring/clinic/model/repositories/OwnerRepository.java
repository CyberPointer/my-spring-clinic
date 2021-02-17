package com.my.spring.clinic.model.repositories;

import com.my.spring.clinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
