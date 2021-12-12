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

//    @Override
//    public EntityObject update(int id, Prescription prescription){
//        EntityObject entityObject = repo.findById(id).get();
//        EntityObject entity = factory.getDaoEntity(prescription);
//        entityObject.setId(id);
//        entityObject.setValueEntities(entity.getValueDBList());
//        return repo.save(entityObject);
//    }
}
