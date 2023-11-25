package karizma.recette.services;

import karizma.recette.entities.Ingredient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IIngredientService {
    List<Ingredient> getIngredients();

    Ingredient addIngredient(Ingredient ingredient);


    String deleteIngredient(Long id);

    Ingredient getIngredientById(Long id);

    Ingredient updateIngredient(Long id, Ingredient ingredient);

    Page<Ingredient> getIngredients(Pageable pageable);

    Page<Ingredient> searchIngredients(String keyword, Pageable pageable);

    Page<Ingredient> searchIngredients(String keyword, Long sem, Pageable pageable);

    List<Ingredient> getClassByEtape(Long etapeId);

}
