package whereToLunch.service;

import org.springframework.util.Assert;
import whereToLunch.util.exception.NotFoundException;
import whereToLunch.model.Cafe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import whereToLunch.repository.CafeRepository;
import static whereToLunch.util.ValidationUtil.*;
import java.util.List;

/**
 * Created by Eugene on 16.03.2017.
 */
@Service("cafeService")
public class CafeServiceImpl implements CafeService {

    @Autowired
    private CafeRepository repository;

    @Override
    public Cafe get(int id) throws NotFoundException {
        return checkNotFoundWithId(repository.get(id), id);
    }

    @Override
    public void delete(int id) throws NotFoundException {
        checkNotFoundWithId(repository.delete(id),id);
    }

    @Override
    public List<Cafe> getAll() {
        return repository.getAll();
    }

    @Override
    public Cafe save(Cafe cafe) {
        Assert.notNull(cafe, "cafe must not be null");
        return repository.save(cafe);
    }

    @Override
    public void update(Cafe cafe) {
        Assert.notNull(cafe, "cafe must not be null");
        checkNotFoundWithId(cafe,cafe.getId());
        repository.save(cafe);
    }
}
