package pi.enset.services;

import org.springframework.web.bind.annotation.RequestParam;
import pi.enset.entities.Classe;
import pi.enset.entities.Etudiant;

import java.util.List;

public interface IEtudiantService {

    Etudiant addEtudiant(Etudiant etudiant, Long classeId);

    List<Etudiant> searchEtudiant(Long idClasse);

    String deleteEtudiant(Long id);
}
