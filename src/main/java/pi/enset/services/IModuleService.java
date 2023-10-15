package pi.enset.services;

import pi.enset.entities.Enseignant;
import pi.enset.entities.Module;

import java.util.List;

public interface IModuleService {
    List<Module> getModules();

    Module addModule(Module module,Long classeId);

    String deleteModule(Long id);

    Module getModuleById(Long id);

    Module updateModule(Long id, Module module);

    List<Module> getModuleByEnseignant(Enseignant enseignant);
}
