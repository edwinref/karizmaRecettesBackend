package pi.enset.web;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pi.enset.entities.AffectationModuleGroupeTeacher;
import pi.enset.services.IAffect;

@Slf4j
@CrossOrigin("*")
@RestController
@RequestMapping("/api/affects")
@AllArgsConstructor
public class AffectController {

    @Autowired
    private IAffect iAffect;

    @PostMapping()
    AffectationModuleGroupeTeacher save(@RequestBody AffectationModuleGroupeTeacher affect){
        return iAffect.save(affect);
    }
}
