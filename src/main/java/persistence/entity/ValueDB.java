package persistence.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "value")
public class ValueDB {

    @NotNull
    @JoinColumn(name = "type",referencedColumnName = "id")
    @Column(name="object_id")
    private ObjectDB objectDB;

    @NotNull
    @OneToMany(mappedBy = "object_id",cascade = CascadeType.ALL)
    @JoinColumn(name = "type",referencedColumnName = "id")
    @Column(name="attribute_id")
    private Set<AttributeDB> attributeDB;

    @Column(name="num_value")
    private int numValue;

    @Column(name="varchar_value")
    private String varcharValue;

    @Column(name="date_value")
    @Temporal(TemporalType.DATE)
    private LocalDate date;

    public ObjectDB getObjectDB() {
        return objectDB;
    }

    public void setObjectDB(ObjectDB objectDB) {
        this.objectDB = objectDB;
    }

    public Set<AttributeDB> getAttributeDB() {
        return attributeDB;
    }

    public void setAttributeDB(Set<AttributeDB> attributeDB) {
        this.attributeDB = attributeDB;
    }

    public int getNumValue() {
        return numValue;
    }

    public void setNumValue(int numValue) {
        this.numValue = numValue;
    }

    public String getVarcharValue() {
        return varcharValue;
    }

    public void setVarcharValue(String varcharValue) {
        this.varcharValue = varcharValue;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
