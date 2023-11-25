package karizma.recette.repository;

import karizma.recette.entities.Ingredient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

    @Query("select e from Ingredient e where e.id = ?1")
    Ingredient getIngredientsByID(Long Id);
    @Query("SELECT i FROM Ingredient i WHERE i.id = :id")
    Ingredient findIngredientById(@Param("id") Long id);
}
