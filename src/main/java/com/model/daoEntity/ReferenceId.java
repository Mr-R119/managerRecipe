package com.model.daoEntity;

import java.io.Serializable;
import java.util.Objects;

public class ReferenceId implements Serializable {

//    private static final long serialVersionUID = 1L;

    private int object_id;

    private int attribute_id;

    private int reference_id;

    public ReferenceId() {
    }

    public ReferenceId(int object_id, int attribute_id, int reference_id) {
        this.object_id = object_id;
        this.attribute_id = attribute_id;
        this.reference_id = reference_id;
    }

    public int getObject_id() {
        return object_id;
    }

    public void setObject_id(int object_id) {
        this.object_id = object_id;
    }

    public int getAttribute_id() {
        return attribute_id;
    }

    public void setAttribute_id(int attribute_id) {
        this.attribute_id = attribute_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(object_id, attribute_id,reference_id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ReferenceId referenceId = (ReferenceId) obj;
        return Objects.equals(object_id,referenceId.object_id) &&
                Objects.equals(attribute_id,referenceId.attribute_id) &&
                Objects.equals(reference_id,referenceId.reference_id);
    }
}
