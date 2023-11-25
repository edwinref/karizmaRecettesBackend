package karizma.recette.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data

@DiscriminatorValue("UserR")
public class UserR extends Person {
}
