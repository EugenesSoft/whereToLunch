package whereToLunch.service;

import org.springframework.util.Assert;
import whereToLunch.util.exception.NotFoundException;
import whereToLunch.model.Dish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import whereToLunch.repository.DishRepository;

import java.util.List;

import static whereToLunch.util.ValidationUtil.checkNotFoundWithId;

/**
 * Created by Eugene on 16.03.2017.
 */
@Service("dishService")
public class DishServiceImpl implements DishService {

    @Autowired
    private DishRepository repository;

    @Override
    public Dish get(int id) throws NotFoundException {
        return checkNotFoundWithId(repository.get(id), id);
    }

    @Override
    public void delete(int id) throws NotFoundException {
        checkNotFoundWithId(repository.delete(id), id);
    }

    @Override
    public List<Dish> getAllForCafe(int cafeId) {
        return repository.getAllForCafe(cafeId);
    }


    @Override
    public List<Dish> getAll() {
        return repository.getAll();
    }

    @Override
    public Dish update(Dish dish, int cafeId) throws NotFoundException {
        Assert.notNull(dish, "dish must not be null");
        return checkNotFoundWithId(repository.save(dish,cafeId), dish.getId());
    }

    @Override
    public Dish save(Dish dish, int cafeId) {
        Assert.notNull(dish, "dish must not be null");
        return repository.save(dish,cafeId);
    }
}
