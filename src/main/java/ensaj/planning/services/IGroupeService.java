package ensaj.planning.services;

import ensaj.planning.entities.Groupe;

import java.util.List;

public interface IGroupeService {
    Groupe save(Groupe groupe);

    List<Groupe> getGroupByclasse(Long id);

    List<Groupe> getGroupByModule(Long id);
}
