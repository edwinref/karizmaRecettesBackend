package karizma.recette.services;

import karizma.recette.repository.IngredientRepository;
import karizma.recette.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import karizma.recette.entities.UserR;

import java.util.List;

@Service
public class IUserRServiceImpl implements IUserRService {

    @Autowired
    private UserRepository userRepository;
    private final IngredientRepository ingredientRepository;

    @Autowired
    public IUserRServiceImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    @Transactional
    public UserR addUserR(UserR userR, Long groupeId) {
        return userRepository.save(userR);
    }

    @Override
    public List<UserR> searchUserR(Long idIngredient) {
        return null;
    }


    @Override
    public String deleteUserR(Long id) {
        try {
            userRepository.getById(id);
            userRepository.deleteById(id);
            return "L'operation est bien effectuée";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public UserR getEtudById(Long id) {
        return userRepository.getEtudByid(id);
    }

    @Override
    public Page<UserR> getUserRs(Pageable pageable) {
        return userRepository.findUsersByRoles("UserR", pageable);
    }

    @Override
    public List<UserR> getUserRss() {
        return userRepository.findAllByRoleUserR("UserR");
    }

    @Override
    public Page<UserR> searchUserRs(String keyword, Pageable pageable) {
        return userRepository.searchWithPaginationUserR(keyword, pageable);
    }

    @Override
    public List<UserR> getAllUserR() {
        return userRepository.findAllByRoleUserR("UserR");
    }

    @Override
    public List<UserR> findUserRByNom(String nom) {
        return userRepository.findEnseignantByNomUserR(nom);
    }

}