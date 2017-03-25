package whereToLunch.web.cafe;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import whereToLunch.model.Cafe;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Eugene on 24.03.2017.
 */
@RestController
@RequestMapping(value = "/ajax/cafes")
public class CafeAjaxController extends AbstractCafeController {

    @Override
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Cafe> getAll() {
        return super.getAll();
    }

    @Override
    @GetMapping(value = "/{id}")
    public Cafe get(@PathVariable("id") int id) {
        return super.get(id);
    }

    @Override
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") int id) {
        super.delete(id);
    }

    @PostMapping
    public void updateOrCreate(@Valid Cafe cafe) {
        if (cafe.isNew()) {
            super.create(cafe);
        } else {
            super.update(cafe, cafe.getId());
        }
    }

}
