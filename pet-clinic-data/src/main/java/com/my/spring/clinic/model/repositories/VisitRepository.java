package com.my.spring.clinic.model.repositories;

import com.my.spring.clinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
