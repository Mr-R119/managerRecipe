package persistence.daoEntity;

import java.time.LocalDate;

public class Prescription {

    private long id;
    private Patient patient;
    private Doctor doctor;
    private LocalDate createDate;
    private LocalDate expirationDate;
    private Priority priority;

    public Prescription(){
    }

    public Prescription(Patient patient, Doctor doctor, LocalDate createDate, LocalDate expirationDate, Priority priority) {
        this.patient = patient;
        this.doctor = doctor;
        this.createDate = createDate;
        this.expirationDate = expirationDate;
        this.priority = priority;
    }

    public long getId() {
        return id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
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

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }
}
