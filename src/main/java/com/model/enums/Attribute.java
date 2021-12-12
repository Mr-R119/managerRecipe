package com.model.enums;

import java.util.HashMap;
import java.util.Map;


public enum Attribute {
    FIRST_NAME("first_name", 1),
    SECOND_NAME("second_name", 2),
    PATRONYMIC("patronymic", 3),
    PHONE("phone", 4),
    SPECIALIZATION("specialization", 5),
    CREATE_DATE("create_date", 6),
    EXPIRATION_DATE("expiration_date", 7),
    DESCRIPTION("description", 8),
    PATIENT_PRESCRIPTION("patient_prescription", 9),
    DOCTOR_PRESCRIPTION("doctor_prescription", 10),
    PRIORITY("priority",11),
    DOCTOR_PATIENT("doctor_patient", 12);

    private static final Map<String, Attribute> BY_NAME = new HashMap<>();
    private static final Map<Integer, Attribute> BY_ID = new HashMap<>();

    static {
        for (Attribute e : values()) {
            BY_NAME.put(e.name, e);
            BY_ID.put(e.id, e);
        }
    }

    public final int id;
    public final String name;

    Attribute(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public static Attribute attributeOfName(String name) {
        return BY_NAME.get(name);
    }

    public static Attribute attributeById(int id) {
        return BY_ID.get(id);
    }

}
