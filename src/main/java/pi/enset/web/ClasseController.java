package pi.enset.web;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import pi.enset.entities.Classe;
import pi.enset.entities.Filiere;
import pi.enset.services.IClasseService;
import pi.enset.services.IFiliereService;

@Slf4j
@CrossOrigin("*")
@RestController
@RequestMapping("/api/classes")
@AllArgsConstructor
public class ClasseController {
    private final IClasseService classeService;
    private final IFiliereService filiereService;
    @GetMapping
    public Page<Classe> getAllClasses(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        return classeService.getClasses(pageable);
    }

    @GetMapping("/{id}")
    public Classe getClasseById(@PathVariable Long id) {
        return classeService.getClasseById(id);
    }

    @PostMapping
    public Classe createClasse(@RequestBody Classe classe, @RequestParam Long filiereId) {
        return classeService.addClasse(classe, filiereId);
    }


    @PutMapping("/{id}")
    public Classe updateClasse(@PathVariable Long id, @RequestBody Classe updatedClasse, @RequestParam Long filiereId) {
        Classe existingClasse = classeService.getClasseById(id);

        if (existingClasse != null) {
            existingClasse.setLibelle(updatedClasse.getLibelle());
            existingClasse.setNbrEleves(updatedClasse.getNbrEleves());
            Filiere filiere = filiereService.getFiliereById(filiereId);

            if (filiere != null) {
                existingClasse.setFiliere(filiere);
            } else {

                return null;
            }
            return classeService.updateClasse(id, existingClasse);
        } else {

            return null;
        }
    }


    @DeleteMapping("/{id}")
    public String deleteClasse(@PathVariable Long id) {
        return classeService.deleteClasse(id);
    }

    @GetMapping("/search")
    public Page<Classe> searchClasses(
            @RequestParam String keyword,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        return classeService.searchClasses(keyword, pageable);
    }
    @GetMapping("/searchSem")
    public Page<Classe> searchClassesSem(
            @RequestParam String keyword,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam Long sem
    ) {
        Pageable pageable = PageRequest.of(page, size);
        return classeService.searchClasses(keyword,sem, pageable);
    }
}
