package com.service.impl;

import com.factory.impl.DoctorEntity;
import com.model.daoEntity.EntityObject;
import com.model.entity.impl.Doctor;
import com.repository.CommonRepository;
import org.springframework.stereotype.Service;


@Service
public class DoctorService extends AbstractService<CommonRepository<EntityObject>, DoctorEntity,Doctor> {

    public DoctorService(CommonRepository<EntityObject> repo, DoctorEntity factory) {
        super(repo, factory);
    }
}
