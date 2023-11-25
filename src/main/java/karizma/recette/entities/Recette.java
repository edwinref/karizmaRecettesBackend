package karizma.recette.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("ADMIN")
public class Recette  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String libelle;

    @OneToMany(mappedBy = "recette", cascade = CascadeType.ALL)
    private List<Ingredient> ingredients = new ArrayList<>();

    @OneToMany(mappedBy = "recette", cascade = CascadeType.ALL)
    private List<Etape> etapes = new ArrayList<>();

    private int dureePreparation; // Duration in minutes

    // Constructors, getters, and setters
}

