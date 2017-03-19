package whereToLunch.service;



import whereToLunch.to.UserTo;
import whereToLunch.util.exception.NotFoundException;
import whereToLunch.model.User;

import java.util.List;

/**
 * Created by Eugene on 12.03.2017.
 */
public interface UserService {

    User save(User user);

    void delete(int id) throws NotFoundException;

    User get(int id) throws NotFoundException;

    User getByEmail(String email) throws NotFoundException;

    List<User> getAll();

    void update(User user);

    void update(UserTo userTo);

    void evictCache();

    void enable(int id, boolean enabled);

    void voteForCafe(int id, int cafeId) throws NotFoundException;

}
