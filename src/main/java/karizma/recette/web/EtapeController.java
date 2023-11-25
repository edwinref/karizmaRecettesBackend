package karizma.recette.web;

import karizma.recette.entities.Etape;
import karizma.recette.services.IEtapeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@Slf4j
@CrossOrigin("*")
@RestController
@RequestMapping("/api/etapes")
@AllArgsConstructor
public class EtapeController {

    private final IEtapeService etapeService;

    @GetMapping
    public Page<Etape> getAllEtapes(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return etapeService.getEtapes(pageable);
    }

    @GetMapping("/{id}")
    public Etape getEtapeById(@PathVariable Long id) {
        return etapeService.getEtapeById(id);
    }

    @PostMapping
    public Etape createEtape(@RequestBody Etape etape) {
        return etapeService.addEtape(etape);
    }

    @PutMapping("/{id}")
    public Etape updateEtape(@PathVariable Long id, @RequestBody Etape updatedEtape) {
        return etapeService.updateEtape(id, updatedEtape);
    }

    @DeleteMapping("/{id}")
    public String deleteEtape(@PathVariable Long id) {
        return etapeService.deleteEtape(id);
    }

    @GetMapping("/search")
    public Page<Etape> searchEtapes(
            @RequestParam String keyword,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return etapeService.searchEtapes(keyword, pageable);
    }

}
