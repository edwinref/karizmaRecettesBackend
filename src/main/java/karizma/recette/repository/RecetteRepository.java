package karizma.recette.repository;

import karizma.recette.entities.Recette;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RecetteRepository extends JpaRepository<Recette, Long> {

}
