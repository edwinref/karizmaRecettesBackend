package ensaj.planning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ensaj.planning.entities.Groupe;

import java.util.List;

public interface GroupeRepository extends JpaRepository<Groupe, Long> {

    @Query("select e from Groupe e where e.id = ?1")
    Groupe getGroupeByID(Long Id);

    @Query("select g from Groupe g where g.classe.id = ?1")
    List<Groupe> getGroupeByClasse_Id(Long classId);

    @Query("select g from Groupe g where g.classe in (select m.classe from Module m where m.id = ?1)")
    List<Groupe> getGroupByModule(Long classId);
}
