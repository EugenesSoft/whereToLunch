package whereToLunch.web.dish;

import whereToLunch.model.Dish;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import whereToLunch.service.DishService;

import java.util.List;

import static whereToLunch.util.ValidationUtil.checkIdConsistent;
import static whereToLunch.util.ValidationUtil.checkNew;

/**
 * Created by Eugene on 17.03.2017.
 */
public abstract class AbstractDishController {
    private static final Logger LOG = LoggerFactory.getLogger(AbstractDishController.class);

    @Autowired
    private DishService service;

    public Dish get(int id){
        LOG.info("get dish {}", id);
        return service.get(id);
    }

    public void delete(int id){
        LOG.info("delete dish {}", id);
        service.delete(id);
    }

    public List<Dish> getAll(int cafeId){
        LOG.info("get all dishes for cafe {}", cafeId);
        return service.getAll(cafeId);
    }

    public Dish update(Dish dish, int cafeId, int id){
        checkIdConsistent(dish, id);
        LOG.info("update the dish {} for cafe {}",dish, cafeId);
        return service.update(dish, cafeId);
    }

    public Dish create(Dish dish, int cafeId){
        checkNew(dish);
        LOG.info("create dish {} for cafe {}",dish, cafeId);
        return service.save(dish, cafeId);
    }



}
