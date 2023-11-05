package pi.enset.web;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pi.enset.entities.Classe;
import pi.enset.entities.Groupe;
import pi.enset.services.IGroupeService;

import java.util.List;

@Slf4j
@CrossOrigin("*")
@RestController
@RequestMapping("/api/groupes")
@AllArgsConstructor
public class GroupeController {

    @Autowired
    private IGroupeService iGroupeService;
    @PostMapping
    public Groupe createGroupe(@RequestBody Groupe groupe) {
        return iGroupeService.save(groupe);
    }

    @GetMapping("/{id}")
    public List<Groupe> getGroupsByclasse(@PathVariable Long id){
        return iGroupeService.getGroupByclasse(id);
    }

    @GetMapping("/module/{id}")
    public List<Groupe> getGroupsByModule(@PathVariable Long id){
        return iGroupeService.getGroupByModule(id);
    }
}
