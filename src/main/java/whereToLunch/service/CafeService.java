package whereToLunch.service;

import whereToLunch.util.exception.NotFoundException;
import whereToLunch.model.Cafe;

import java.util.List;

/**
 * Created by Eugene on 13.03.2017.
 */
public interface CafeService {

    Cafe get(int id) throws NotFoundException;

    void delete(int id) throws NotFoundException;

    List<Cafe> getAll();

    Cafe save(Cafe cafe);

    void update(Cafe cafe);

}
