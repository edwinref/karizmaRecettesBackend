package pi.enset.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pi.enset.entities.Classe;
import pi.enset.entities.Enseignant;
import pi.enset.entities.Etudiant;
import pi.enset.repository.ClasseRepository;
import pi.enset.repository.UserRepository;

import java.util.List;

@Service
public class IEtudiantServiceImpl implements IEtudiantService {

    @Autowired
    private UserRepository userRepository;
    private final ClasseRepository classeRepository;

    @Autowired
    public IEtudiantServiceImpl(ClasseRepository classeRepository) {
        this.classeRepository = classeRepository;
    }

    @Override
    @Transactional
    public Etudiant addEtudiant(Etudiant etudiant, Long classeId) {
        Classe classe = classeRepository.findById(classeId).orElse(null);
        etudiant.setClasse(classe);
        return userRepository.save(etudiant);
    }

    @Override
    public List<Etudiant> searchEtudiant(Long idClasse) {
        return userRepository.searchByClasse(idClasse);
    }


    @Override
    public String deleteEtudiant(Long id) {
        try {
            userRepository.getById(id);
            userRepository.deleteById(id);
            return "L'operation est bien effectuée";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public Etudiant getEtudById(Long id) {
        return userRepository.getEtudByid(id);
    }

    @Override
    public Page<Etudiant> getEtudiants(Pageable pageable) {
        return  userRepository.findUsersByRoles("Etudiant",pageable);
    }

    @Override
    public List<Etudiant> getEtudiantss() {
        return userRepository.findAllByRoleEtudiant("Etudiant");
    }

    @Override
    public Page<Etudiant> searchEtudiants(String keyword, Pageable pageable) {
        return  userRepository.searchWithPaginationEtudiant(keyword, pageable);
    }

    @Override
    public List<Etudiant> getAllEtudiant() {
        return  userRepository.findAllByRoleEtudiant("Etudiant");
    }

    @Override
    public List<Etudiant> findEtudiantByNom(String nom) {
        return  userRepository.findEnseignantByNomEtudiant(nom);
    }


}
