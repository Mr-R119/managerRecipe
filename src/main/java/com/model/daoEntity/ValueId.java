package com.model.daoEntity;

import java.io.Serializable;
import java.util.Objects;

public class ValueId implements Serializable {

    private int object_id;

    private int attribute_id;

    public ValueId() {
    }

    public ValueId(int objectId, int attributeId) {
        this.object_id = objectId;
        this.attribute_id = attributeId;
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
        return Objects.hash(object_id, attribute_id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ValueId attrObjId = (ValueId) obj;
        return Objects.equals(object_id,attrObjId.object_id) &&
                Objects.equals(attribute_id,attrObjId.attribute_id);
    }
}
