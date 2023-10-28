package pi.enset.services;

import pi.enset.entities.Classe;
import pi.enset.entities.Enseignant;
import pi.enset.entities.Etudiant;

import java.util.List;

public interface IEtudiantService {
    Etudiant addEtudiant(Etudiant etudiant);

    List<Etudiant> searchEtudiant(Long idClasse);

    String deleteEtudiant(Long id);

    Etudiant getEtudById(Long id);
}
