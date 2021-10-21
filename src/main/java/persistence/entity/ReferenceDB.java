package persistence.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "reference")
public class ReferenceDB {

    @Column(name = "object_id")
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(name = "object", joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "id"))
    private List<Long> objectId;

    @Column(name = "attribute_id")
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(name = "object", joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "id"))
    private List<Long> attributeId;

    @Column(name = "reference_id")
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(name = "object", joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "id"))
    private List<Long> referenceId;

    public List<Long> getObjectId() {
        return objectId;
    }

    public void setObjectId(List<Long> objectId) {
        this.objectId = objectId;
    }

    public List<Long> getAttributeId() {
        return attributeId;
    }

    public void setAttributeId(List<Long> attributeId) {
        this.attributeId = attributeId;
    }

    public List<Long> getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(List<Long> referenceId) {
        this.referenceId = referenceId;
    }
}
