package com.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum TypeEntity {
    PATIENT("Patient", 1),
    DOCTOR("Doctor", 2),
    PRESCRIPTION("Prescription", 3);


    private static final Map<String,TypeEntity> BY_NAME = new HashMap<>();
    private static final Map<Integer,TypeEntity> BY_ID = new HashMap<>();

    static {
        for (TypeEntity e : values()) {
            BY_NAME.put(e.name, e);
            BY_ID.put(e.id, e);
        }
    }

    public final int id;
    public final String name;

    TypeEntity(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public static TypeEntity typeOfName(String name) {
        return BY_NAME.get(name);
    }

    public static TypeEntity typeById(int id) {
        return BY_ID.get(id);
    }

}
