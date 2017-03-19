package whereToLunch.model;

import javax.persistence.*;
import java.util.*;

/**
 * Created by Eugene on 12.03.2017.
 */

@SuppressWarnings("JpaQlInspection")
@Entity
@Table(name = "cafes")
public class Cafe extends NamedEntity {


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cafe")
    protected List<Dish> lunchMenu;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "voteForCafe")
    private Set<User> userVotes;

    public Cafe() {
    }

    public Cafe(Integer id, String name) {
        super(id, name);
        this.lunchMenu = new ArrayList<Dish>();
        this.userVotes = new HashSet<>();
    }

    public List<Dish> getLunchMenu() {
        return lunchMenu;
    }

    public void setLunchMenu(List<Dish> lunchMenu) {
        this.lunchMenu = lunchMenu;
    }

    public Set<User> getUserVotes() {
        return userVotes;
    }

    public void setUserVotes(Set<User> userVotes) {
        this.userVotes = userVotes;
    }

    @Override
    public String toString() {
        return "Cafe{" +
                "id=" + getId() +
                ", name=" + getName() +
                "}";
    }
}
