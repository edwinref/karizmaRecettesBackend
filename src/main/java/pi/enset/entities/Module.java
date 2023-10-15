package pi.enset.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Module {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int volumeHoraireOnsite;
    private int volumeHoraireOnRemote;
    private int nbrTD;
    private int nbrTP;
    private int nbrEvaluation;
    private String libelle;
    private boolean isSeperated;
    private boolean isMetuale;
    @ManyToOne
    private Classe classe;
    @ManyToOne
    private Enseignant enseignant;
}
