package whereToLunch.web.json;

import org.junit.Test;
import whereToLunch.model.User;
import whereToLunch.testData.UserTestData;

import java.util.List;

/**
 * Created by Eugene on 24.03.2017.
 */
public class JsonUtilTest {

    @Test
    public void testReadWriteValue() throws Exception {
        String json = JsonUtil.writeValue(UserTestData.USER);
        System.out.println(json);
        User user = JsonUtil.readValue(json, User.class);
        UserTestData.MATCHER.assertEquals(UserTestData.USER, user);
    }

    @Test
    public void testReadWriteValues() throws Exception {
        String json = JsonUtil.writeValue(UserTestData.USERS);
        System.out.println(json);
        List<User> meals = JsonUtil.readValues(json, User.class);
        UserTestData.MATCHER.assertCollectionEquals(UserTestData.USERS, meals);
    }
}
