package persistence.daoEntity;

public class Doctor {

    private String firstName;
    private String secondName;
    private String patronymic;
    private Specialization specialization;

    public Doctor(){
    }

    public Doctor(String firstName, String secondName, String patronymic, Specialization specialization) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.patronymic = patronymic;
        this.specialization = specialization;
    }


}
