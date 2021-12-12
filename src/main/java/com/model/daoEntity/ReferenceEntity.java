package com.model.daoEntity;

import javax.persistence.*;

@Entity
@IdClass(ReferenceId.class)
@Table(name = "reference")
public class ReferenceEntity {

    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "object_id")
    private EntityObject object_id;

    @Id
    @Column(name = "attribute_id")
    private int attribute_id;

    @Id
    @Column(name = "reference_id")
    private int reference_id;

    public ReferenceEntity() {
    }

    public ReferenceEntity(EntityObject object_id, int attribute_id, int reference_id) {
        this.object_id = object_id;
        this.attribute_id = attribute_id;
        this.reference_id = reference_id;
    }

    public EntityObject getObject_id() {
        return object_id;
    }

    public int getAttribute_id() {
        return attribute_id;
    }

    public int getReference_id() {
        return reference_id;
    }
}
