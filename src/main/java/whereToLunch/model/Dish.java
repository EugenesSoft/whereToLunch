package whereToLunch.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.SafeHtml;

import javax.persistence.*;

/**
 * Created by Eugene on 12.03.2017.
 */

@Entity
@Table(name = "dishes")
public class Dish extends BaseEntity {

    @Column(name = "description", nullable = false)
    @NotBlank
    @SafeHtml
    private String description;

    @Column(name = "price")
    @NotBlank
    @SafeHtml
    private double price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cafe_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Cafe cafe;

    public Dish() {
    }

    public Dish(Integer id, String description, double price) {
        super(id);
        this.description = description;
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Cafe getCafe() {
        return cafe;
    }

    public void setCafe(Cafe cafe) {
        this.cafe = cafe;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "id=" + getId() +
                ", description=" + description +
                ", price=" + price +
                '}';
    }
}
