package karizma.recette;

import karizma.recette.entities.Admin;
import karizma.recette.entities.enums.TypeAdmin;
import karizma.recette.repository.IngredientRepository;
import karizma.recette.repository.EtapeRepository;
import karizma.recette.repository.RecetteRepository;
import karizma.recette.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RecetteKArizma {
    public static void main(String[] args) {
        SpringApplication.run(RecetteKArizma.class, args);
    }

    @Bean
    CommandLineRunner lineRunner(UserRepository userRepository,
            IngredientRepository ingredientRepository,
            RecetteRepository salleRepository,
            EtapeRepository etapeRepository) {
        return args -> {
            // Create the Admin
            Admin admin = new Admin();
            admin.setNom("REFKI");
            admin.setPrenom("ELHADI");
            admin.setEmail("admin@admin.com");
            admin.setPassword("admin");
            admin.setTel("0600000000");
            admin.setCivilite("M");
            admin.setLogin("admin");
            admin.setCne("555");
            admin.setAdmin_type(TypeAdmin.SUPER_ADMIN);
            // userRepository.save(admin);

        };

    }

}
