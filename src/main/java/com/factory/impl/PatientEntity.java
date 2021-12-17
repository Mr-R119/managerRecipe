package com.factory.impl;

import com.factory.EntityFactory;
import com.model.daoEntity.BackReferenceEntity;
import com.model.daoEntity.EntityObject;
import com.model.daoEntity.ReferenceEntity;
import com.model.daoEntity.ValueEntity;
import com.model.entity.AbstractEntity;
import com.model.entity.impl.Patient;
import com.model.enums.Attribute;
import com.model.enums.TypeEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class PatientEntity implements EntityFactory {
    @Override
    public Patient getRealEntity(EntityObject commonEntityDao) {
        Patient patient = new Patient();
        patient.setId(commonEntityDao.getId());
        patient.setFirstName(commonEntityDao.getFirstName());
        patient.setSecondName(commonEntityDao.getSecondName());
        patient.setPatronymic(commonEntityDao.getPatronymic());
        patient.setPhone(commonEntityDao.getPhone());
        patient.setPrescriptionList(commonEntityDao.getPatientPrescriptions());

        return patient;
    }

    @Override
    public EntityObject getDaoEntity(AbstractEntity abstractEntity) {
        if(abstractEntity instanceof Patient){
            EntityObject entityObject = new EntityObject();
            entityObject.setTypeId(TypeEntity.PATIENT.id);

            List<ValueEntity> valueEntities = new ArrayList<>();
            Collections.addAll(valueEntities,
                    new ValueEntity(entityObject, Attribute.FIRST_NAME.id,((Patient) abstractEntity).getFirstName()));
            Collections.addAll(valueEntities,
                    new ValueEntity(entityObject, Attribute.SECOND_NAME.id,((Patient) abstractEntity).getSecondName()));
            Collections.addAll(valueEntities,
                    new ValueEntity(entityObject, Attribute.PATRONYMIC.id,((Patient) abstractEntity).getPatronymic()));
            Collections.addAll(valueEntities,
                    new ValueEntity(entityObject, Attribute.PHONE.id,((Patient) abstractEntity).getPhone()));
            entityObject.setValueEntities(valueEntities);

            List<BackReferenceEntity> backReferenceEntities = new ArrayList<>();
            entityObject.setBackReferenceEntities(backReferenceEntities);

            if(((Patient) abstractEntity).getPrescriptionList() != null &&!((Patient) abstractEntity).getPrescriptionList().isEmpty()){
                List<ReferenceEntity> referenceEntities = new ArrayList<>();
                for(Integer prescription : ((Patient) abstractEntity).getPrescriptionList()){
                    Collections.addAll(referenceEntities,
                            new ReferenceEntity(entityObject, Attribute.PATIENT_PRESCRIPTION.id, prescription));
                    entityObject.setReferenceEntities(referenceEntities);
                }
            }
            return entityObject;
        }
        return null;
    }
}
