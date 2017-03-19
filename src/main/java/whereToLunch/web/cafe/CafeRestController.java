package whereToLunch.web.cafe;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import whereToLunch.model.Cafe;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;

/**
 * Created by Eugene on 18.03.2017.
 */
@RestController
@RequestMapping(CafeRestController.REST_URL)
public class CafeRestController extends AbstractCafeController {
    static final String REST_URL = "/rest/cafes";

    @Override
    @GetMapping("/{id}")
    public Cafe get(@PathVariable("id") int id) {
        return super.get(id);
    }

    @Override
    @DeleteMapping("/{id}")
    void delete(@PathVariable("id") int id) {
        super.delete(id);
    }

    @Override
    @GetMapping
    public List<Cafe> getAll() {
        return super.getAll();
    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cafe> createWithLocation(@Valid @RequestBody Cafe cafe) {

        Cafe created = super.create(cafe);

        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL + "/{id}")
                .buildAndExpand(created.getId()).toUri();

        return ResponseEntity.created(uriOfNewResource).body(created);
    }

    @Override
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@Valid @RequestBody Cafe cafe, @PathVariable("id") int id) {
        super.update(cafe, id);
    }
}
