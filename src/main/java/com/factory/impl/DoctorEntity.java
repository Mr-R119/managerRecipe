package com.factory.impl;

import com.factory.EntityFactory;
import com.model.daoEntity.BackReferenceEntity;
import com.model.daoEntity.EntityObject;
import com.model.daoEntity.ReferenceEntity;
import com.model.daoEntity.ValueEntity;
import com.model.entity.AbstractEntity;
import com.model.entity.impl.Doctor;
import com.model.enums.Attribute;
import com.model.enums.TypeEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DoctorEntity implements EntityFactory {
    @Override
    public Doctor getRealEntity(EntityObject commonEntityDao) {
        Doctor doctor = new Doctor();
        doctor.setId(commonEntityDao.getId());
        doctor.setFirstName(commonEntityDao.getFirstName());
        doctor.setSecondName(commonEntityDao.getSecondName());
        doctor.setPatronymic(commonEntityDao.getPatronymic());
        doctor.setSpecialization(commonEntityDao.getSpecialization());
        doctor.setPatientList(commonEntityDao.getDoctorPatients());
        return doctor;
    }

    @Override
    public EntityObject getDaoEntity(AbstractEntity abstractEntity) {
        if(abstractEntity instanceof Doctor) {
                EntityObject entityObject = new EntityObject();
                entityObject.setTypeId(TypeEntity.DOCTOR.id);

                List<ValueEntity> valueEntities = new ArrayList<>();
                Collections.addAll(valueEntities,
                        new ValueEntity(entityObject, Attribute.FIRST_NAME.id, ((Doctor) abstractEntity).getFirstName()));
                Collections.addAll(valueEntities,
                        new ValueEntity(entityObject, Attribute.SECOND_NAME.id, ((Doctor) abstractEntity).getSecondName()));
                Collections.addAll(valueEntities,
                        new ValueEntity(entityObject, Attribute.PATRONYMIC.id, ((Doctor) abstractEntity).getPatronymic()));
                Collections.addAll(valueEntities,
                        new ValueEntity(entityObject, Attribute.SPECIALIZATION.id, ((Doctor) abstractEntity).getSpecialization()));
                entityObject.setValueEntities(valueEntities);

                List<BackReferenceEntity> backReferenceEntities = new ArrayList<>();
                entityObject.setBackReferenceEntities(backReferenceEntities);

                if (((Doctor) abstractEntity).getPatientList() != null && !((Doctor) abstractEntity).getPatientList().isEmpty()) {
                    List<ReferenceEntity> referenceEntities = new ArrayList<>();
                    for (Integer patient : ((Doctor) abstractEntity).getPatientList()) {
                        Collections.addAll(referenceEntities,
                                new ReferenceEntity(entityObject, Attribute.DOCTOR_PATIENT.id, patient));
                        entityObject.setReferenceEntities(referenceEntities);
                    }
                }
                return entityObject;

        }
        return null;
    }
}
