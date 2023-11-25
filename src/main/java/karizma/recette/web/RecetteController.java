package karizma.recette.web;

import karizma.recette.entities.Recette;
import karizma.recette.services.IRecetteService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@Slf4j
@CrossOrigin("*")
@RestController
@RequestMapping("/api/recettes")
@AllArgsConstructor
public class RecetteController {

    private final IRecetteService salleService;

    @GetMapping
    public Page<Recette> getAllRecettes(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return salleService.getRecettes(pageable);
    }

    @GetMapping("/{id}")
    public Recette getRecetteById(@PathVariable Long id) {
        return salleService.getRecetteById(id);
    }

    @PostMapping
    public Recette createRecette(@RequestBody Recette recette) {
        return salleService.addRecette(recette);
    }

    @PutMapping("/{id}")
    public Recette updateRecette(@PathVariable Long id, @RequestBody Recette updatedRecette) {
        return salleService.updateRecette(id, updatedRecette);
    }

    @DeleteMapping("/{id}")
    public String deleteRecette(@PathVariable Long id) {
        System.out.println("deleteRecette" + id);
        return salleService.deleteRecette(id);
    }


}
