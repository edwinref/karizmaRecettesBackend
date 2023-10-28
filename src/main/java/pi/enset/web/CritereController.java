package pi.enset.web;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pi.enset.entities.Criteria;
import pi.enset.entities.Etudiant;
import pi.enset.services.ICriteriaService;

import java.util.List;

@Slf4j
@CrossOrigin("*")
@RestController
@RequestMapping("/api/criteria")
public class CritereController {
    @Autowired
    ICriteriaService icriteriaService;


    @PostMapping("/save")
    public Criteria createCriteria(@RequestBody Criteria criteria) {
            return icriteriaService.save(criteria);
    }

    @GetMapping("/{id}")
    public Criteria getCriteriaByStud(@PathVariable Long id) {
        return icriteriaService.getCriteriaByStud(id);
    }


}
