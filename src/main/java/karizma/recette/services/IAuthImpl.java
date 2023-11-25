package karizma.recette.services;

import karizma.recette.entities.AuthRespense;
import karizma.recette.entities.Person;
import karizma.recette.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class IAuthImpl implements IAuth {
    private UserRepository userRepository;

    @Override
    public AuthRespense login(String login, String password) {
        System.out.println("login " + login + " password " + password);
        Person person = userRepository.findByLoginAndPassword(login, password);
        System.out.println("wwwwwwwwwwwwwwwwwwww" + person.getRole());
        System.out.println("person ");
        if (person != null) {
            person.setAuthentificated(true);
            System.out.println("wwwwwwwwwwwwwww" + person.getPrenom());
            userRepository.save(person);
            return new AuthRespense("token", person.getRole().equals("ADMIN"), person.getNom(), person.getId(),
                    person.getPrenom(), person.getRole().equals("PROF"), person.getRole().equals("UserR"), true);
        }
        return new AuthRespense();
    }

    @Override
    public void logout(Long id) {
        Person person = userRepository.findById(id).orElseThrow(() -> new RuntimeException("Person not found"));
        person.setAuthentificated(false);
        userRepository.save(person);
    }
}
