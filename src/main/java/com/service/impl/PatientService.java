package com.service.impl;

import com.factory.impl.PatientEntity;
import com.model.daoEntity.EntityObject;
import com.model.entity.impl.Patient;
import com.repository.CommonRepository;
import org.springframework.stereotype.Service;

@Service
public class PatientService extends AbstractService<CommonRepository<EntityObject>, PatientEntity, Patient> {

    public PatientService(CommonRepository<EntityObject> repo, PatientEntity factory) {
        super(repo, factory);
    }

//    @Override
//    public EntityObject update(int id, Patient patient){
//        EntityObject entityObject = repo.findById()
//        EntityObject entity = factory.getDaoEntity(patient);
//        entityObject.setId(id);
//        return repo.save(entityObject);
//    }
}
