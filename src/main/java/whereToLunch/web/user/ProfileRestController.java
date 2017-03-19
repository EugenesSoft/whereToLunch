package whereToLunch.web.user;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import whereToLunch.AuthorizedUser;
import whereToLunch.model.User;
import whereToLunch.to.UserTo;
import javax.validation.Valid;

/**
 * Created by Eugene on 18.03.2017.
 */
@RestController
@RequestMapping(ProfileRestController.REST_URL)
public class ProfileRestController extends AbstractUserController {

    static final String REST_URL = "/rest/profile";

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public User get() {
        return super.get(AuthorizedUser.id());
    }

    @DeleteMapping
    public void delete() {
        super.delete(AuthorizedUser.id());
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@Valid @RequestBody UserTo userTo) {
        super.update(userTo, AuthorizedUser.id());
    }

    @Override
    @PutMapping(value = "/{id}-vote-for-{cafeId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void voteForCafe(@PathVariable("id") int id, int cafeId) {
        super.voteForCafe(id, cafeId);
    }
}
