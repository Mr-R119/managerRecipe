package persistence.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "object")
public class ObjectDB implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type",referencedColumnName = "id")
    @Column(name="type_id")
    private TypeDB typeId;

    public long getId() {
        return id;
    }


    public TypeDB getTypeId() {
        return typeId;
    }

    public void setTypeId(TypeDB typeId) {
        this.typeId = typeId;
    }
}
