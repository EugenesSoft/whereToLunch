package whereToLunch.to;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.SafeHtml;
import whereToLunch.HasId;

import javax.persistence.Column;

/**
 * Created by Eugene on 25.03.2017.
 */
public class DishTo extends BaseTo {

    @Column(name = "description", nullable = false)
    @NotBlank
    @SafeHtml
    private String description;

    @Column(name = "price")
    @NotBlank
    @SafeHtml
    private double price;

    @SafeHtml
    private String cafeName;

    public DishTo() {
    }

    public DishTo(Integer id, String description, double price){
        super(id);
        this.description = description;
        this.price = price;

    }



}
