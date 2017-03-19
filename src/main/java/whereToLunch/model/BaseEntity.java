package whereToLunch.model;

import whereToLunch.HasId;

import javax.persistence.*;

/**
 * Created by Eugene on 12.03.2017.
 */

@MappedSuperclass
@Access(AccessType.FIELD)
public abstract class BaseEntity implements HasId {

    public static final int START_SEQ = 100000;

    @Id
    @SequenceGenerator(name = "global_seq", sequenceName = "global_seq", allocationSize = 1, initialValue = 100000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "global_seq")
    @Access(value = AccessType.PROPERTY)
    private Integer id;

    public BaseEntity() {
    }

    public BaseEntity(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public boolean isNew(){
        return getId() == null;
    }



}
