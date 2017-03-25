package whereToLunch.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import whereToLunch.util.exception.NotFoundException;

import java.util.Arrays;

import static whereToLunch.testData.CafeTestData.LIDO_ID;
import static whereToLunch.testData.DishTestData.*;

/**
 * Created by Eugene on 16.03.2017.
 */
public class DishServiceTest extends AbstractServiceTest {

    @Autowired
    protected DishService service;

    @Test
    public void testGet() throws Exception {

    }

    @Test
    public void delete() throws Exception {
        service.delete(DISH_3.getId());
        MATCHER.assertCollectionEquals(Arrays.asList(DISH_1, DISH_2, DISH_4), service.getAllForCafe(LIDO_ID));
    }

    @Test
    public void testDeleteNotFound() throws Exception {
        thrown.expect(NotFoundException.class);
        service.delete(1);
    }

    @Test
    public void getAll() throws Exception {

    }

    @Test
    public void update() throws Exception {

    }

    @Test
    public void save() throws Exception {

    }

}