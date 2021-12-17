package com.factory.impl;

import com.factory.EntityFactory;
import com.model.daoEntity.BackReferenceEntity;
import com.model.daoEntity.EntityObject;
import com.model.daoEntity.ReferenceEntity;
import com.model.daoEntity.ValueEntity;
import com.model.entity.AbstractEntity;
import com.model.entity.impl.Prescription;
import com.model.enums.Attribute;
import com.model.enums.TypeEntity;
import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class PrescriptionEntity implements EntityFactory {
    @Override
    public Prescription getRealEntity(EntityObject commonEntityDao) {
        Prescription prescription = new Prescription();
        prescription.setId(commonEntityDao.getId());
        prescription.setPatientId(commonEntityDao.getPatientId());
        prescription.setDoctorId(commonEntityDao.getDoctorId());
        prescription.setDescription(commonEntityDao.getDescription());
        prescription.setCreateDate(commonEntityDao.getCreateDate());
        prescription.setExpirationDate(commonEntityDao.getExpirationDate());
        prescription.setPriority(commonEntityDao.getPriority());
        return prescription;
    }

    @Override
    public EntityObject getDaoEntity(AbstractEntity abstractEntity) {
        if (abstractEntity instanceof Prescription) {
            EntityObject entityObject = new EntityObject();
            entityObject.setTypeId(TypeEntity.PRESCRIPTION.id);

            List<ValueEntity> valueEntities = new ArrayList<>();
            Collections.addAll(valueEntities,
                    new ValueEntity(entityObject, Attribute.DESCRIPTION.id, ((Prescription) abstractEntity).getDescription()));
            Collections.addAll(valueEntities,
                    new ValueEntity(entityObject, Attribute.CREATE_DATE.id, Date.from(((Prescription) abstractEntity).getCreateDate().atStartOfDay(ZoneId.systemDefault()).toInstant())));
            Collections.addAll(valueEntities,
                    new ValueEntity(entityObject, Attribute.EXPIRATION_DATE.id, Date.from(((Prescription) abstractEntity).getExpirationDate().atStartOfDay(ZoneId.systemDefault()).toInstant())));
            Collections.addAll(valueEntities,
                    new ValueEntity(entityObject, Attribute.PRIORITY.id, ((Prescription) abstractEntity).getPriority()));
            entityObject.setValueEntities(valueEntities);

            List<ReferenceEntity> referenceEntities = new ArrayList<>();
            entityObject.setReferenceEntities(referenceEntities);

            List<BackReferenceEntity> backReferenceEntities = new ArrayList<>();
            Collections.addAll(backReferenceEntities,
                    new BackReferenceEntity(((Prescription) abstractEntity).getPatientId(), Attribute.PATIENT_PRESCRIPTION.id, entityObject));
            Collections.addAll(backReferenceEntities,
                    new BackReferenceEntity(((Prescription) abstractEntity).getDoctorId(), Attribute.DOCTOR_PRESCRIPTION.id, entityObject));
            entityObject.setBackReferenceEntities(backReferenceEntities);
            return entityObject;
        }
        return null;
    }
}
