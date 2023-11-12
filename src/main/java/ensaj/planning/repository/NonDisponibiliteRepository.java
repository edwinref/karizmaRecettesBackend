package ensaj.planning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ensaj.planning.entities.NonDisponibilite;

public interface NonDisponibiliteRepository extends JpaRepository<NonDisponibilite, Long> {
}
