package pi.enset.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pi.enset.entities.AffectationModuleGroupeTeacher;
import pi.enset.entities.Classe;

public interface AffectRepository extends JpaRepository<AffectationModuleGroupeTeacher, Long> {
}
