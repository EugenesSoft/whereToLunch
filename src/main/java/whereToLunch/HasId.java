package whereToLunch;

/**
 * Created by Eugene on 17.03.2017.
 */
public interface HasId {
    Integer getId();

    void setId(Integer id);

    default boolean isNew() {
        return (getId() == null);
    }
}
