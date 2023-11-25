package karizma.recette.services;

import karizma.recette.entities.Ingredient;
import karizma.recette.repository.EtapeRepository;
import karizma.recette.repository.IngredientRepository;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class IIngredientServiceImpl implements IIngredientService {
    private IngredientRepository ingredientRepository;
    private EtapeRepository etapeRepository;

    @Override
    public List<Ingredient> getIngredients() {
        return ingredientRepository.findAll();
    }

    @Override
    public Ingredient addIngredient(Ingredient ingredient) {

        return ingredientRepository.save(ingredient);
    }

    @Override
    public String deleteIngredient(Long id) {
        try {
            getIngredientById(id);
            ingredientRepository.deleteById(id);
            return "La suppression de ingredient est bien effectuée";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public Ingredient getIngredientById(Long id) {
        return ingredientRepository.findById(id).orElseThrow(() -> new RuntimeException("La ingredient n'existe pas!"));
    }

    @Override
    public Ingredient updateIngredient(Long id, Ingredient updatedIngredient) {
        // Check if the class with the given ID exists
        Ingredient existingIngredient = ingredientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("La ingredient avec l'ID " + id + " n'existe pas"));

        // Update the fields of the existing class with the data from updatedIngredient
        existingIngredient.setLibelle(updatedIngredient.getLibelle());

        // Ensure that the etape is correctly set (assuming that etape is a required
        // field)

        // Save the updated class entity
        return ingredientRepository.save(existingIngredient);
    }

    @Override
    public Page<Ingredient> getIngredients(Pageable pageable) {
        return ingredientRepository.findAll(pageable);
    }

    @Override
    public Page<Ingredient> searchIngredients(String keyword, Pageable pageable) {
        return null;
    }

    @Override
    public Page<Ingredient> searchIngredients(String keyword, Long sem, Pageable pageable) {
        return null;
    }

    @Override
    public List<Ingredient> getClassByEtape(Long etapeId) {
        return null;
    }


}
