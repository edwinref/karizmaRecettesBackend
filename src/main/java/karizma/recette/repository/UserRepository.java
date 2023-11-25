package karizma.recette.repository;

import karizma.recette.entities.Recette;
import karizma.recette.entities.UserR;
import karizma.recette.entities.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Person, Long> {

    @Query("SELECT u FROM Person u WHERE u.Role = ?1")
    Page<Recette> findUsersByRole(String role, Pageable pageable);

    @Query("SELECT u FROM Person u WHERE u.Role = ?1")
    Page<UserR> findUsersByRoles(String role, Pageable pageable);



    @Query("SELECT e FROM Person e WHERE (e.nom LIKE %?1% OR e.prenom LIKE %?1%) AND e.Role = 'UserR'")
    Page<UserR> searchWithPaginationUserR(String keyword, Pageable pageable);

    @Query("SELECT u FROM Person u WHERE u.Role = ?1")
    List<Recette> findAllByRole(String role);

    @Query("SELECT u FROM Person u WHERE u.Role = ?1")
    List<UserR> findAllByRoleUserR(String role);


    @Query("SELECT u FROM Person u WHERE u.Role = 'UserR' AND (u.nom LIKE %?1% OR u.prenom LIKE %?1%)")
    List<UserR> findEnseignantByNomUserR(String nom);

    @Query("SELECT u FROM Person u WHERE u.login = ?1 AND u.password = ?2")
    Person findByLoginAndPassword(String login, String password);



    @Query("SELECT e from Person e where e.id = ?1")
    UserR getEtudByid(Long id);
}
