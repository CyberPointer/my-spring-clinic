package com.my.spring.clinic.model.services.map;

import com.my.spring.clinic.model.Speciality;
import com.my.spring.clinic.model.services.SpecialtiesService;

import java.util.Set;

public class SpecialitiesServiceMap extends  AbstractMapService<Speciality, Long> implements SpecialtiesService {
    @Override
    public Set<Speciality> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Speciality object) {
        super.delete(object);
    }

    @Override
    public Speciality save(Speciality object) {
        return super.save(object);
    }

    @Override
    public Speciality findById(Long id) {
        return super.findById(id);
    }
}
