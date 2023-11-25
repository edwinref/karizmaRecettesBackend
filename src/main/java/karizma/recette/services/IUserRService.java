package karizma.recette.services;

import karizma.recette.entities.UserR;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IUserRService {

    UserR addUserR(UserR userR, Long ingredientId);

    List<UserR> searchUserR(Long idIngredient);

    String deleteUserR(Long id);

    UserR getEtudById(Long id);

    Page<UserR> getUserRs(Pageable pageable);

    List<UserR> getUserRss();

    Page<UserR> searchUserRs(String keyword, Pageable pageable);

    List<UserR> getAllUserR();

    List<UserR> findUserRByNom(String nom);
}