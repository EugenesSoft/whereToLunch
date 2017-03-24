package whereToLunch.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import whereToLunch.model.Role;
import whereToLunch.model.User;

/**
 * Created by Eugene on 23.03.2017.
 */
public class UserServiceTest extends AbstractServiceTest {

    @Autowired
    private UserService service;

    @Test
    public void testSave() throws Exception {
        service.save(new User(null,"Billy","billy@mail.ru","spring99", Role.ROLE_USER));
    }

    @Test
    public void delete() throws Exception {

    }

    @Test
    public void get() throws Exception {

    }

    @Test
    public void getByEmail() throws Exception {

    }

    @Test
    public void getAll() throws Exception {

    }

    @Test
    public void update() throws Exception {

    }

    @Test
    public void update1() throws Exception {

    }

    @Test
    public void enable() throws Exception {

    }

    @Test
    public void voteForCafe() throws Exception {

    }

}
