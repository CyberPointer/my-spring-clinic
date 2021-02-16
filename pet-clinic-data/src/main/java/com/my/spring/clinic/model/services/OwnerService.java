package com.my.spring.clinic.model.services;

import com.my.spring.clinic.model.Owner;

public interface OwnerService extends CrudService<Owner,Long> {

    Owner findByLastName(String lastName);

}
