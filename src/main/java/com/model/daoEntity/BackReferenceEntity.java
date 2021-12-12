package com.model.daoEntity;

import javax.persistence.*;

@Entity
@IdClass(ReferenceId.class)
@Table(name = "reference")
public class BackReferenceEntity {

    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "reference_id")
    private EntityObject reference_id;

    @Id
    @Column(name = "attribute_id")
    private int attribute_id;

    @Id
    @Column(name = "object_id")
    private int object_id;

    public BackReferenceEntity() {
    }

    public BackReferenceEntity(int object_id, int attribute_id, EntityObject reference_id) {
        this.reference_id = reference_id;
        this.attribute_id = attribute_id;
        this.object_id = object_id;
    }

    public EntityObject getReference_id() {
        return reference_id;
    }

    public int getAttribute_id() {
        return attribute_id;
    }

    public int getObject_id() {
        return object_id;
    }
}
