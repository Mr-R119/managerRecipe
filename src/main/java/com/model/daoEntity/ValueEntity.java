package com.model.daoEntity;

import javax.persistence.*;
import java.util.Date;

@Entity
@IdClass(ValueId.class)
@Table(name = "value")
public class ValueEntity {

    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "object_id")
    private EntityObject object_id;

    @Id
    @Column(name = "attribute_id")
    private int attribute_id;

    @Column(name = "num_value")
    private Integer numValue;

    @Column(name = "varchar_value")
    private String varcharValue;

    @Column(name = "date_value")
    private Date dateValue;

    public ValueEntity() {
    }

    public ValueEntity(EntityObject object_id, int attribute_id, String varcharValue) {
        this.object_id = object_id;
        this.attribute_id = attribute_id;
        this.varcharValue = varcharValue;
    }

    public ValueEntity(EntityObject object_id, int attribute_id, Integer numValue) {
        this.object_id = object_id;
        this.attribute_id = attribute_id;
        this.numValue = numValue;
    }

    public ValueEntity(EntityObject object_id, int attribute_id, Date dateValue) {
        this.object_id = object_id;
        this.attribute_id = attribute_id;
        this.dateValue = dateValue;
    }

    public ValueEntity(EntityObject object_id, int attribute_id, int numValue, String varcharValue, Date dateValue) {
        this.object_id = object_id;
        this.attribute_id = attribute_id;
        this.numValue = numValue;
        this.varcharValue = varcharValue;
        this.dateValue = dateValue;
    }

    public int getAttribute_id() {
        return attribute_id;
    }

    public Integer getNumValue() {
        return numValue;
    }

    public void setNumValue(Integer numValue) {
        this.numValue = numValue;
    }

    public String getVarcharValue() {
        return varcharValue;
    }

    public void setVarcharValue(String varcharValue) {
        this.varcharValue = varcharValue;
    }

    public Date getDateValue() {
        return dateValue;
    }

    public void setDateValue(Date dateValue) {
        this.dateValue = dateValue;
    }
}
