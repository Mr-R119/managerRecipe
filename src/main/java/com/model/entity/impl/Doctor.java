package com.model.entity.impl;

import com.model.entity.AbstractEntity;

import java.util.List;


public class Doctor extends AbstractEntity {

    private String firstName;
    private String secondName;
    private String patronymic;
    private String specialization;

    private List<Integer> patientList;

    public Doctor(){
    }

    public Doctor(String firstName, String secondName, String patronymic, String specialization) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.patronymic = patronymic;
        this.specialization = specialization;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public List<Integer> getPatientList() {
        return patientList;
    }

    public void setPatientList(List<Integer> patientList) {
        this.patientList = patientList;
    }
}
