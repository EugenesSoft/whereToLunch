package whereToLunch.repository.impls;

import whereToLunch.model.Dish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import whereToLunch.repository.DishRepository;
import whereToLunch.repository.datajpa.CrudCafeRepository;
import whereToLunch.repository.datajpa.CrudDishRepository;

import java.util.List;

/**
 * Created by Eugene on 15.03.2017.
 */
@Repository
public class DishRepositoryImpl implements DishRepository {

    @Autowired
    private CrudDishRepository crudDishRepository;

    @Autowired
    private CrudCafeRepository crudCafeRepository;

    @Override
    public Dish save(Dish dish, int cafeId) {
        dish.setCafe(crudCafeRepository.getOne(cafeId));
        return crudDishRepository.save(dish);
    }

    @Override
    public boolean delete(int id) {
        return crudDishRepository.delete(id) != 0;
    }

    @Override
    public Dish get(int id) {
        Dish dish = crudDishRepository.findOne(id);
        return dish != null ? dish : null;
    }

    @Override
    public List<Dish> getAll(int cafeId) {
        return crudDishRepository.getAll(cafeId);
    }

}
