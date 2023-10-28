package pi.enset.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pi.enset.entities.Classe;
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


}
