package whereToLunch.repository;

import whereToLunch.model.User;

import java.util.List;

/**
 * Created by Eugene on 13.03.2017.
 */
public interface UserRepository {

    User save(User user);

    boolean delete(int id);

    User get(int id);

    User getByEmail(String email);

    List<User> getAll();

}
