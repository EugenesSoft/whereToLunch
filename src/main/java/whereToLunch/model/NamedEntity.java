package whereToLunch.model;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.SafeHtml;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * Created by Eugene on 13.03.2017.
 */

@MappedSuperclass
public abstract class NamedEntity extends BaseEntity {

    @NotBlank
    @SafeHtml
    @Column(name = "name", nullable = false)
    private String name;

    public NamedEntity() {
    }

    public NamedEntity(Integer id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
