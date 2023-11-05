package pi.enset.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pi.enset.entities.Groupe;
import pi.enset.entities.Module;
import pi.enset.repository.AffectRepository;
import pi.enset.repository.GroupeRepository;
import pi.enset.repository.ModuleRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class IGroupeServiceImpl implements IGroupeService {

    @Autowired
    private GroupeRepository groupeRepository;

    @Autowired
    private ModuleRepository moduleRepository;

    @Override
    public Groupe save(Groupe groupe) {
        return groupeRepository.save(groupe);
    }

    @Override
    public List<Groupe> getGroupByclasse(Long id) {
        return groupeRepository.getGroupeByClasse_Id(id);
    }

    @Override
    public List<Groupe> getGroupByModule(Long id) {
        List<Groupe> mg= groupeRepository.getGroupByModule(id);
        List<Groupe> groupes = new ArrayList<Groupe>();
        for (Groupe m: mg){
            List<Module> modules = moduleRepository.getModuleByGroupe(m.getId());
            boolean t = true;
            for(Module module:modules){
                if(id.equals(module.getId())){
                    t=false;
                }
            }
            if(t){
                groupes.add(m);
            }
        }
        return groupes;
    }
}
