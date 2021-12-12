package com.model.entity.impl;

import com.model.entity.AbstractEntity;

import java.time.LocalDate;

public class Prescription extends AbstractEntity {

    private int patientId;
    private int doctorId;
    private String description;
    private LocalDate createDate;
    private LocalDate expirationDate;
    private String priority;

    public Prescription(){
    }

    public Prescription(int patientId, int doctorId, String description, LocalDate createDate, LocalDate expirationDate, String priority) {
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.description = description;
        this.createDate = createDate;
        this.expirationDate = expirationDate;
        this.priority = priority;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }
}
