package persistence.entity;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "type")
public enum TypeDB {
    PATIENT("Patient", 1),
    DOCTOR("Doctor", 2),
    PRESCRIPTION("Prescription", 3);


    private static final Map<String,TypeDB> BY_NAME = new HashMap<>();
    private static final Map<Long,TypeDB> BY_ID = new HashMap<>();

    static {
        for (TypeDB e : values()) {
            BY_NAME.put(e.name, e);
            BY_ID.put(e.id, e);
        }
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    public final long id;

    @Column(name = "name")
    public final String name;

    private TypeDB(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public static TypeDB valueOfName(String name) {
        return BY_NAME.get(name);
    }

    public static TypeDB valueById(long id) {
        return BY_ID.get(id);
    }

}
