package pi.enset.web;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import pi.enset.entities.Module;
import pi.enset.services.IClasseService;
import pi.enset.services.IModuleService;

import java.util.List;

@Slf4j
@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/modules")
public class ModuleController {
    private final IModuleService moduleService;
    private final IClasseService iClasseService;



    @GetMapping
    public List<Module> getAllModules() {
        return moduleService.getModules();
    }

    @GetMapping("/{id}")
    public Module getModuleById(@PathVariable Long id) {
        return moduleService.getModuleById(id);
    }

    @PostMapping
    public Module createModule(@RequestBody Module module,@RequestParam Long classeId) {
        return moduleService.addModule(module,classeId);
    }

    @PutMapping("/{id}")
    public Module updateModule(@PathVariable Long id, @RequestBody Module updatedModule, @RequestParam Long classeId) {
        Module existingModule = moduleService.getModuleById(id);

        if (existingModule != null) {
            existingModule.setVolumeHoraireOnsite(updatedModule.getVolumeHoraireOnsite());
            existingModule.setVolumeHoraireOnRemote(updatedModule.getVolumeHoraireOnRemote());
            existingModule.setNbrTD(updatedModule.getNbrTD());
            existingModule.setNbrTP(updatedModule.getNbrTP());
            existingModule.setNbrEvaluation(updatedModule.getNbrEvaluation());
            existingModule.setLibelle(updatedModule.getLibelle());
            existingModule.setSeperated(updatedModule.isSeperated());
            existingModule.setMetuale(updatedModule.isMetuale());
            existingModule.setClasse(iClasseService.getClasseById(classeId));

            return moduleService.updateModule(id,existingModule);
        } else {

            return null;
        }
    }

    @DeleteMapping("/{id}")
    public String deleteModule(@PathVariable Long id) {
        return moduleService.deleteModule(id);
    }
}
