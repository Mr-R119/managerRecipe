package com.model.daoEntity;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import static com.model.enums.Attribute.*;

@Entity
@Table(name = "object")
public class EntityObject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotNull
    @Column(name = "type_id")
    private int typeId;

    @OneToMany(mappedBy = "object_id", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ValueEntity> valueEntities;

    @OneToMany(mappedBy = "object_id", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ReferenceEntity> referenceEntities;

    @OneToMany(mappedBy = "reference_id", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BackReferenceEntity> backReferenceEntities;

    public EntityObject(){
    }

    public EntityObject(int id, int typeId){
        this.id = id;
        this.typeId = typeId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public List<ValueEntity> getValueDBList() {
        return valueEntities;
    }

    public ValueEntity getValue(int attrId) {
        return getValueDBList().stream().filter(i -> i.getAttribute_id() == attrId).findFirst().get();
    }

    public void setValueEntities(List<ValueEntity> valueEntities) {
        this.valueEntities = valueEntities;
    }

    public void setReferenceEntities(List<ReferenceEntity> referenceEntities) {
        this.referenceEntities = referenceEntities;
    }

    public List<BackReferenceEntity> getBackReferenceEntities() {
        return backReferenceEntities;
    }

    public BackReferenceEntity getBackReference(int attrId){
        return getBackReferenceEntities().stream().filter(i -> i.getAttribute_id() == attrId).findFirst().get();
    }

    public void setBackReferenceEntities(List<BackReferenceEntity> backReferenceEntities) {
        this.backReferenceEntities = backReferenceEntities;
    }

    public String getFirstName() {
        return getValue(FIRST_NAME.id).getVarcharValue();
    }

    public String getSecondName() {
        return getValue(SECOND_NAME.id).getVarcharValue();
    }

    public String getPatronymic() {
        return getValue(PATRONYMIC.id).getVarcharValue();
    }

    public String getPhone() {
        return getValue(PHONE.id).getVarcharValue();
    }

    public String getSpecialization() {
        return getValue(SPECIALIZATION.id).getVarcharValue();
    }

    public LocalDate getCreateDate() {
        return getValue(CREATE_DATE.id).getDateValue().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public LocalDate getExpirationDate() {
        return getValue(EXPIRATION_DATE.id).getDateValue().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public String getDescription() {
        return getValue(DESCRIPTION.id).getVarcharValue();
    }

    public String getPriority(){
        return getValue(PRIORITY.id).getVarcharValue();
    }

    public int getPatientId(){
        return getBackReference(PATIENT_PRESCRIPTION.id).getObject_id();
    }

    public int getDoctorId(){
        return getBackReference(DOCTOR_PRESCRIPTION.id).getObject_id();
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public List<ReferenceEntity> getReferenceEntities() {
        return referenceEntities;
    }

    public ReferenceEntity getReference(int attr){
        return getReferenceEntities().stream().filter(r -> r.getAttribute_id()==attr).findFirst().get();
    }

    public List<Integer> getDoctorPatients(){
        List<Integer> patientList = new ArrayList<>();
        for(ReferenceEntity referenceEntity : getReferenceEntities()){
            if(this.id == referenceEntity.getObject_id().getId() && referenceEntity.getAttribute_id() == DOCTOR_PATIENT.id){
                patientList.add(referenceEntity.getReference_id());
            }
        }
        return patientList;
    }

    public List<Integer> getPatientDoctors(){
        List<Integer> doctorList = new ArrayList<>();
        for(BackReferenceEntity backReferenceEntity : getBackReferenceEntities()){
            if(this.id == backReferenceEntity.getReference_id().getId() && backReferenceEntity.getAttribute_id() == DOCTOR_PATIENT.id){
                doctorList.add(backReferenceEntity.getObject_id());
            }
        }
        return doctorList;
    }

    public List<Integer> getPatientPrescriptions(){
        List<Integer> patientPrescriptionList = new ArrayList<>();
        for(ReferenceEntity referenceEntity : getReferenceEntities()) {
            if (this.id == referenceEntity.getObject_id().getId() && referenceEntity.getAttribute_id() == PATIENT_PRESCRIPTION.id) {
                patientPrescriptionList.add(referenceEntity.getReference_id());
            }
        }
        return patientPrescriptionList;
    }

    public List<Integer> getDoctorPrescriptions(){
        List<Integer> doctorPrescriptionList = new ArrayList<>();
        for(ReferenceEntity referenceEntity : getReferenceEntities()) {
            if (this.id == referenceEntity.getObject_id().getId() && referenceEntity.getAttribute_id() == DOCTOR_PRESCRIPTION.id) {
                doctorPrescriptionList.add(referenceEntity.getReference_id());
            }
        }
        return doctorPrescriptionList;
    }
}
