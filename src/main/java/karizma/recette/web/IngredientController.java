package karizma.recette.web;

import karizma.recette.entities.Ingredient;
import karizma.recette.entities.Etape;
import karizma.recette.services.IIngredientService;
import karizma.recette.services.IEtapeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@CrossOrigin("*")
@RestController
@RequestMapping("/api/ingredients")
@AllArgsConstructor
public class IngredientController {
    private final IIngredientService ingredientService;
    private final IEtapeService etapeService;

    @GetMapping
    public Page<Ingredient> getAllIngredients(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return ingredientService.getIngredients(pageable);
    }

    @GetMapping("/all")
    public List<Ingredient> getAllingredients() {
        return ingredientService.getIngredients();
    }

    @GetMapping("/{id}")
    public Ingredient getIngredientById(@PathVariable Long id) {
        return ingredientService.getIngredientById(id);
    }

    @PostMapping
    public Ingredient createIngredient(@RequestBody Ingredient ingredient) {
        return ingredientService.addIngredient(ingredient);
    }

    @PutMapping("/{id}")
    public Ingredient updateIngredient(@PathVariable Long id, @RequestBody Ingredient updatedIngredient) {
        System.out.println("Received PUT request for ingredient with id: " + id);

        Ingredient existingIngredient = ingredientService.getIngredientById(id);
        System.out.println("Existing ingredient: " + existingIngredient);

        if (existingIngredient != null) {
            existingIngredient.setLibelle(updatedIngredient.getLibelle());
            System.out.println("Updating ingredient: " + existingIngredient);

            return ingredientService.updateIngredient(id, existingIngredient);
        } else {
            System.out.println("Ingredient not found with id: " + id);
            return null;
        }
    }


    @DeleteMapping("/{id}")
    public String deleteIngredient(@PathVariable Long id) {
        return ingredientService.deleteIngredient(id);
    }

    @GetMapping("/search")
    public Page<Ingredient> searchIngredients(
            @RequestParam String keyword,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return ingredientService.searchIngredients(keyword, pageable);
    }

    @GetMapping("/searchSem")
    public Page<Ingredient> searchIngredientsSem(
            @RequestParam String keyword,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam Long sem) {
        Pageable pageable = PageRequest.of(page, size);
        return ingredientService.searchIngredients(keyword, sem, pageable);
    }



}
