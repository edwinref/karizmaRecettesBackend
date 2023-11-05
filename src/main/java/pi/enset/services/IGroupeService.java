package pi.enset.services;

import pi.enset.entities.Groupe;

import java.util.List;

public interface IGroupeService {
    Groupe save(Groupe groupe);

    List<Groupe> getGroupByclasse(Long id);

    List<Groupe> getGroupByModule(Long id);
}
