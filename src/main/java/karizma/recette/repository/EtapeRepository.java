package karizma.recette.repository;

import karizma.recette.entities.Etape;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EtapeRepository extends JpaRepository<Etape, Long> {
    @Query("select e from Etape e where e.libelle LIKE %?1% ")
    Page<Etape> searchEtapes(String keyword, Pageable pageable);

}
