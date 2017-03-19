package whereToLunch.repository;

import whereToLunch.model.Dish;

import java.util.List;

/**
 * Created by Eugene on 13.03.2017.
 */
public interface DishRepository {

    Dish save(Dish dish, int cafeId);

    boolean delete(int id);

    Dish get(int id);

    List<Dish> getAll(int cafeId);


}
