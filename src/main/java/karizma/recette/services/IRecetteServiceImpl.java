package karizma.recette.services;

import karizma.recette.entities.Recette;
import karizma.recette.repository.RecetteRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class IRecetteServiceImpl implements IRecetteService {
    private RecetteRepository salleRepository;

    @Override
    public List<Recette> getRecettes() {
        return salleRepository.findAll();
    }

    @Override
    public Recette addRecette(Recette recette) {
        return salleRepository.save(recette);
    }

    @Override
    public String deleteRecette(Long id) {
        try {
            getRecetteById(id);
            salleRepository.deleteById(id);
            return "Votre supression est effectuée avec succès";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public Recette getRecetteById(Long id) {
        return salleRepository.findById(id).orElseThrow(() -> new RuntimeException("La recette n'existe pas!"));
    }

    @Override
    public Recette updateRecette(Long id, Recette recette) {
        recette.setId(id);
        return salleRepository.save(recette);
    }


    @Override
    public Page<Recette> getRecettes(Pageable pageable) {
        return salleRepository.findAll(pageable);
    }
}
