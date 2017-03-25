package whereToLunch.web.user;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.core.env.Environment;
import whereToLunch.model.BaseEntity;
import whereToLunch.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import whereToLunch.service.UserService;
import whereToLunch.to.UserTo;

import javax.validation.ValidationException;
import java.util.Arrays;
import java.util.List;

import static whereToLunch.util.ValidationUtil.checkIdConsistent;
import static whereToLunch.util.ValidationUtil.checkNew;

/**
 * Created by Eugene on 17.03.2017.
 */
public class AbstractUserController {
    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private UserService service;

    private boolean systemUserForbiddenModification;

    @Autowired
    public void setEnvironment(Environment environment) {
        systemUserForbiddenModification = Arrays.asList(environment.getActiveProfiles()).size() == 0;
    }

    public void checkModificationAllowed(Integer id) {
        if (systemUserForbiddenModification && id < BaseEntity.START_SEQ + 2) {
            throw new ValidationException(messageSource.getMessage("user.modificationRestriction", null, LocaleContextHolder.getLocale()));
        }
    }

    public User create(User user) {
        checkNew(user);
        log.info("create user {}", user);
        return service.save(user);
    }

    public void delete(int id) {
        log.info("delete " + id);

        service.delete(id);
    }

    public User get(int id){
        log.info("get user {}", id);
        return service.get(id);
    }

    public User getByEmail(String email){
        log.info("get user by email {}", email);
        return service.getByEmail(email);
    }

    public List<User> getAll() {
        log.info("get all users");
        return service.getAll();
    }

    public void update(User user, int id){
        checkIdConsistent(user, id);
        log.info("update user {}", user);
        service.update(user);
    }

    public void update(UserTo userTo, int id) {
        log.info("update " + userTo);
        checkIdConsistent(userTo, id);
        service.update(userTo);
    }

    public void enable(int id, boolean enabled) {
        checkModificationAllowed(id);
        log.info((enabled ? "enable " : "disable ") + id);
        service.enable(id, enabled);
    }

    public void voteForCafe(int id, int cafeId){
        log.info("vote with user {} for cafe {}", id, cafeId);
        service.voteForCafe(id, cafeId);
    }

}
