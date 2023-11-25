package karizma.recette.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import karizma.recette.entities.enums.TypeAdmin;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("ADMIN")
public class Admin extends Person {
    @Enumerated(EnumType.STRING)
    private TypeAdmin admin_type;


}
