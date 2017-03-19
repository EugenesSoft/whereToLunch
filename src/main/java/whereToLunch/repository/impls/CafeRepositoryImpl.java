package whereToLunch.repository.impls;

import whereToLunch.model.Cafe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import whereToLunch.repository.CafeRepository;
import whereToLunch.repository.datajpa.CrudCafeRepository;
import java.util.List;

/**
 * Created by Eugene on 15.03.2017.
 */
@Repository
public class CafeRepositoryImpl implements CafeRepository {

    private static final Sort SORT_NAME = new Sort("name");

    @Autowired
    private CrudCafeRepository crudCafeRepository;

    @Override
    public Cafe save(Cafe cafe) {
        return crudCafeRepository.save(cafe);
    }

    @Override
    public boolean delete(int id) {
        return crudCafeRepository.delete(id) != 0;
    }

    @Override
    public Cafe get(int id) {
        return crudCafeRepository.findOne(id);
    }

    @Override
    public List<Cafe> getAll() {
        return crudCafeRepository.findAll(SORT_NAME);
    }
}
