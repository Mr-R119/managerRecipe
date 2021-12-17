package com.service.impl;

import com.factory.impl.PrescriptionEntity;
import com.model.daoEntity.EntityObject;
import com.model.entity.impl.Prescription;
import com.repository.CommonRepository;
import org.springframework.stereotype.Service;

@Service
public class PrescriptionService extends AbstractService<CommonRepository<EntityObject>, PrescriptionEntity, Prescription>{

    public PrescriptionService(CommonRepository<EntityObject> repo, PrescriptionEntity factory) {
        super(repo, factory);
    }
}
