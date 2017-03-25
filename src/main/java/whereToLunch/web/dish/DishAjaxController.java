package whereToLunch.web.dish;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import whereToLunch.model.Dish;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Eugene on 24.03.2017.
 */
@RestController
@RequestMapping(value = "/ajax/dishes")
public class DishAjaxController extends AbstractDishController {

//    @Override
//    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
//    public List<Dish> getAllForCafe(int cafeId) {
//        return super.getAll(cafeId);
//    }

    @Override
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Dish> getAll() {
        return super.getAll();
    }

    @Override
    @GetMapping(value = "/{id}")
    public Dish get(@PathVariable("id") int id) {
        return super.get(id);
    }

    @Override
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") int id) {
        super.delete(id);
    }

    @PostMapping
    public void updateOrCreate(@Valid Dish dish, int cafeId) {
        if (dish.isNew()) {
            super.create(dish, cafeId);
        } else {
            super.update(dish,cafeId, dish.getId());
        }
    }

}
