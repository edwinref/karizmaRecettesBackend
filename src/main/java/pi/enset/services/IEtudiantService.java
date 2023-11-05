package pi.enset.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pi.enset.entities.Enseignant;
import pi.enset.entities.Etudiant;

import java.util.List;

public interface IEtudiantService {

    Etudiant addEtudiant(Etudiant etudiant, Long classeId);

    List<Etudiant> searchEtudiant(Long idClasse);

    String deleteEtudiant(Long id);

    Etudiant getEtudById(Long id);
    Page<Etudiant> getEtudiants(Pageable pageable);

    List<Etudiant> getEtudiantss();

    Page<Etudiant> searchEtudiants(String keyword, Pageable pageable);

    List<Etudiant> getAllEtudiant();

    List<Etudiant> findEtudiantByNom(String nom);
}
