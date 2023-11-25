package karizma.recette.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthRespense {
    private String token;
    private boolean isAdmin;
    private String nom;
    private Long id;
    private String prenom;
    private boolean isEnseignant;
    private boolean isUserR;
    private boolean isAuthenticated;

    public AuthRespense() {
        this.token = "";
        this.isAdmin = false;
        this.id = 0L;
        this.nom = "";
        this.prenom = "";
        this.isEnseignant = false;
        this.isUserR = false;
        this.isAuthenticated = false;
    }
}
