package whereToLunch.testData;

import whereToLunch.matcher.ModelMatcher;
import whereToLunch.model.Dish;

import java.util.Arrays;
import java.util.List;

import static whereToLunch.model.BaseEntity.START_SEQ;

/**
 * Created by Eugene on 16.03.2017.
 */
public class DishTestData {

    public static final ModelMatcher<Dish> MATCHER = ModelMatcher.of(Dish.class);

    public static final int LIDO_DISH_ID = START_SEQ + 4;
    public static final int MCDAK_DISH_ID = START_SEQ + 8;

    public static final Dish DISH_1 = new Dish(LIDO_DISH_ID,  "Горшочек с мясом", 5.25);
    public static final Dish DISH_2 = new Dish(LIDO_DISH_ID + 1, "Салатик", 1.5 );
    public static final Dish DISH_3 = new Dish(LIDO_DISH_ID + 2, "Супчик", 2.25);
    public static final Dish DISH_4 = new Dish(LIDO_DISH_ID + 3, "Компот", 0.75);

    public static final Dish DISH_5 = new Dish(MCDAK_DISH_ID, "Chicken McNuggets", 2.5);
    public static final Dish DISH_6 = new Dish(MCDAK_DISH_ID + 1, "Hamburger", 2);
    public static final Dish DISH_7 = new Dish(MCDAK_DISH_ID + 2, "Coca-Cola", 1.5);

    public static final List<Dish> DISHES = Arrays.asList(DISH_1, DISH_2, DISH_3, DISH_4, DISH_5, DISH_6, DISH_7);

}
