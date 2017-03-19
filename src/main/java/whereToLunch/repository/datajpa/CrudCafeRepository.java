package whereToLunch.repository.datajpa;

import whereToLunch.model.Cafe;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Eugene on 14.03.2017.
 */
@Transactional(readOnly = true)
public interface CrudCafeRepository extends JpaRepository<Cafe,Integer> {

    @Transactional
    @Modifying
    @Query("DELETE FROM Cafe c WHERE c.id=:id")
    int delete(@Param("id") int id);

    @Override
    Cafe save(Cafe item);

    @Override
    Cafe findOne(Integer id);

    @Override
    List<Cafe> findAll(Sort sort);

}
