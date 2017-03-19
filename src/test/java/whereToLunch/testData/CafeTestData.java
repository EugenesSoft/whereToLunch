package whereToLunch.testData;

import whereToLunch.matcher.ModelMatcher;
import whereToLunch.model.Cafe;

import java.util.Arrays;
import java.util.List;

import static whereToLunch.model.BaseEntity.START_SEQ;

/**
 * Created by Eugene on 16.03.2017.
 */
public class CafeTestData {

    public static final ModelMatcher<Cafe> MATCHER = ModelMatcher.of(Cafe.class);

    public static final int LIDO_ID = START_SEQ + 2;
    public static final int MCDAK_ID = START_SEQ + 3;

    public static final Cafe LIDO = new Cafe(LIDO_ID, "Lido");

    public static final Cafe MCDAK = new Cafe(MCDAK_ID, "McDonalds");

    public static final List<Cafe> CAFES = Arrays.asList(LIDO, MCDAK);
}
