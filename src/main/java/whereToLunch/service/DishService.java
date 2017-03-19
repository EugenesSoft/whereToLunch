package whereToLunch.service;

import whereToLunch.util.exception.NotFoundException;
import whereToLunch.model.Dish;

import java.util.List;

/**
 * Created by Eugene on 12.03.2017.
 */
public interface DishService {

    Dish get(int id) throws NotFoundException;

    void delete(int id) throws NotFoundException;

    List<Dish> getAll(int cafeId);

    Dish update(Dish dish, int cafeId) throws NotFoundException;

    Dish save(Dish dish, int cafeId);
}
