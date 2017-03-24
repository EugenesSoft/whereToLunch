package whereToLunch.testData;

import whereToLunch.matcher.ModelMatcher;
import whereToLunch.model.Role;
import whereToLunch.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static whereToLunch.model.BaseEntity.START_SEQ;

/**
 * Created by Eugene on 16.03.2017.
 */
public class UserTestData {

    private static final Logger LOG = LoggerFactory.getLogger(UserTestData.class);

    public static final int USER_ID = START_SEQ;
    public static final int ADMIN_ID = START_SEQ + 1;

    public static final User USER = new User(USER_ID, "User", "user@yandex.ru", "$2a$10$dySNnvI9ltGzlZuJSlYL7OFl79nG7YTRN6XIinjPXB7l2WtA.ftbi", Role.ROLE_USER);
    public static final User ADMIN = new User(ADMIN_ID, "Admin", "admin@gmail.com", "$2a$10$dySNnvI9ltGzlZuJSlYL7OFl79nG7YTRN6XIinjPXB7l2WtA.ftbi", Role.ROLE_USER, Role.ROLE_ADMIN);

    public static final List<User> USERS = Arrays.asList(USER, ADMIN);


    public static final ModelMatcher<User> MATCHER = ModelMatcher.of(User.class,
            (expected, actual) -> expected == actual ||
                    (Objects.equals(expected.getPassword(), actual.getPassword()))
                            && Objects.equals(expected.getId(), actual.getId())
                            && Objects.equals(expected.getName(), actual.getName())
                            && Objects.equals(expected.getEmail(), actual.getEmail())
                            && Objects.equals(expected.getRoles(), actual.getRoles())
    );


//    private static boolean comparePassword(String rawOrEncodedPassword, String password) {
//        if (PasswordUtil.isEncoded(rawOrEncodedPassword)) {
//            return rawOrEncodedPassword.equals(password);
//        } else if (!PasswordUtil.isMatch(rawOrEncodedPassword, password)) {
//            LOG.error("Password " + password + " doesn't match encoded " + password);
//            return false;
//        }
//        return true;
//    }


}
