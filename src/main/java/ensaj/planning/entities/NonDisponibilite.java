package ensaj.planning.entities;

import ensaj.planning.entities.enums.Periode;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.DayOfWeek;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NonDisponibilite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private DayOfWeek jour;//jourDeLaSemaine
    private Periode periode;
    @ManyToOne
    private Enseignant enseignant;
}
