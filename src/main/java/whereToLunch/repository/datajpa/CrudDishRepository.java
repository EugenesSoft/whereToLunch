package whereToLunch.repository.datajpa;

import whereToLunch.model.Dish;
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
public interface CrudDishRepository extends JpaRepository<Dish, Integer> {

    @Modifying
    @Transactional
    @Query("DELETE FROM Dish d WHERE d.id=:id")
    int delete(@Param("id") int id);

    @Override
    Dish save(Dish item);

    @Query("SELECT d FROM Dish d WHERE d.cafe.id=:cafeId")
    List<Dish> getAll(@Param("cafeId") int cafeId);

    @Query("SELECT d FROM Dish d JOIN FETCH d.cafe WHERE d.id = ?1 and d.cafe.id = ?2")
    Dish getWithCafe(int id, int cafeId);

}
