package com.model.entity.impl;

import com.model.entity.AbstractEntity;

import java.util.List;

public class Patient extends AbstractEntity {

    private String firstName;
    private String secondName;
    private String patronymic;
    private String phone;

    private List<Integer> prescriptionList;

    public Patient(){}

    public Patient(String firstName, String secondName, String patronymic, String phone) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.patronymic = patronymic;
        this.phone = phone;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Integer> getPrescriptionList() {
        return prescriptionList;
    }

    public void setPrescriptionList(List<Integer> prescriptionList) {
        this.prescriptionList = prescriptionList;
    }
}
