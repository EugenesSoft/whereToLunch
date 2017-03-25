package whereToLunch.service;

import whereToLunch.AuthorizedUser;
import whereToLunch.model.Cafe;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import whereToLunch.to.UserTo;
import whereToLunch.util.exception.NotFoundException;
import whereToLunch.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import whereToLunch.repository.CafeRepository;
import whereToLunch.repository.UserRepository;
import static whereToLunch.util.UserUtil.prepareToSave;
import static whereToLunch.util.UserUtil.updateFromTo;
import static whereToLunch.util.ValidationUtil.checkNotFound;
import static whereToLunch.util.ValidationUtil.checkNotFoundWithId;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Eugene on 16.03.2017.
 */
@Service("userService")
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CafeRepository cafeRepository;

    @Override
    public User save(User user) {
        Assert.notNull(user, "user must not be null");
        return userRepository.save(prepareToSave(user));
    }

    @Override
    public void delete(int id) throws NotFoundException {
        checkNotFoundWithId(userRepository.delete(id), id);
    }

    @Override
    public User get(int id) throws NotFoundException {
        return checkNotFoundWithId(userRepository.get(id), id);
    }

    @Override
    public User getByEmail(String email) throws NotFoundException {
        Assert.notNull(email, "email must not be null");
        return checkNotFound(userRepository.getByEmail(email), "email=" + email);
    }

    @Override
    public List<User> getAll() {
        return userRepository.getAll();
    }

    @Override
    public void update(UserTo userTo) {
        User user = updateFromTo(get(userTo.getId()),userTo);
        userRepository.save(prepareToSave(user));
    }

    @Override
    public void update(User user) {
        Assert.notNull(user, "user must not be null");
        userRepository.save(prepareToSave(user));
    }

    @Override
    public void evictCache() {
    }

    @Transactional
    @Override
    public void enable(int id, boolean enabled) {
        User user = get(id);
        user.setEnabled(enabled);
        userRepository.save(user);
    }


    @Transactional
    @Override
    public void voteForCafe(int id, int cafeId) throws NotFoundException {
        Calendar time = Calendar.getInstance();
        if(time.HOUR_OF_DAY >= 12)
            return;

        Cafe cafe = checkNotFoundWithId(cafeRepository.get(id), id);
        User user = get(id);
        Cafe previousUserVote = user.getVoteForCafe();
        if(previousUserVote != null){
            previousUserVote.getUserVotes().remove(user);
        }
        cafe.getUserVotes().add(user);
        user.setVoteForCafe(cafe);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User u = userRepository.getByEmail(email.toLowerCase());
        if (u == null) {
            throw new UsernameNotFoundException("User " + email + " is not found");
        }
        return new AuthorizedUser(u);
    }
}
