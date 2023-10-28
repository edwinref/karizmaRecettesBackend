package pi.enset.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pi.enset.entities.Etudiant;
import pi.enset.repository.UserRepository;

import java.util.List;

@Service
public class IEtudiantServiceImpl implements IEtudiantService{


    @Autowired
    UserRepository userRepository;
    @Override
    public Etudiant addEtudiant(Etudiant etudiant) {
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
