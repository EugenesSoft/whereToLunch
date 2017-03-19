package whereToLunch.web.cafe;

import org.springframework.http.ResponseEntity;
import whereToLunch.model.Cafe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import whereToLunch.service.CafeService;

import java.util.List;

import static whereToLunch.util.ValidationUtil.checkIdConsistent;
import static whereToLunch.util.ValidationUtil.checkNew;

/**
 * Created by Eugene on 17.03.2017.
 */
public abstract class AbstractCafeController {

    private static final Logger LOG = LoggerFactory.getLogger(AbstractCafeController.class);

    @Autowired
    private CafeService service;

    public Cafe get(int id) {
        LOG.info("get cafe {}", id);
        return service.get(id);
    }

    void delete(int id) {
        LOG.info("delete cafe {}", id);
        service.delete(id);
    }

    public List<Cafe> getAll() {
        LOG.info("get all cafes");
        return service.getAll();
    }

    public Cafe create(Cafe cafe) {
        checkNew(cafe);
        LOG.info("create cafe {}", cafe);
        return service.save(cafe);
    }

    public void update(Cafe cafe, int id) {
        checkIdConsistent(cafe, id);
        LOG.info("update cafe {}", cafe);
        service.update(cafe);
    }

}
