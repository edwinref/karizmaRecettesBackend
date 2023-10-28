package pi.enset.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pi.enset.entities.Enseignant;
import pi.enset.entities.Etudiant;
import pi.enset.services.IEtudiantService;

import java.util.List;

@Slf4j
@CrossOrigin("*")
@RestController
@RequestMapping("/api/etudiant")
public class EtudiantController {

    @Autowired
    IEtudiantService iEtudiantService;

    @PostMapping
    public Etudiant createEtudiant(@RequestBody Etudiant etudiant) {
        return iEtudiantService.addEtudiant(etudiant);
    }

    @GetMapping("/{id}")
    public List<Etudiant> getEtudByclass(@PathVariable Long id) {
        return iEtudiantService.searchEtudiant(id);
    }


    @GetMapping("etud/{id}")
    public Etudiant getEnseignantById(@PathVariable Long id) {
        return iEtudiantService.getEtudById(id);
    }
    @DeleteMapping("/{id}")
    public String deleteEnseignant(@PathVariable Long id) {
        return iEtudiantService.deleteEtudiant(id);
    }
}
