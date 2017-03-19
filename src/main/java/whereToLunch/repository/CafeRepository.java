package whereToLunch.repository;

import whereToLunch.model.Cafe;
import java.util.List;

/**
 * Created by Eugene on 13.03.2017.
 */
public interface CafeRepository {

    Cafe save(Cafe cafe);

    boolean delete(int id);

    Cafe get(int id);

    List<Cafe> getAll();


}
