package karizma.recette.services;

import karizma.recette.entities.Recette;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IRecetteService {
    List<Recette> getRecettes();

    Recette addRecette(Recette recette);

    String deleteRecette(Long id);

    Recette getRecetteById(Long id);

    Recette updateRecette(Long id, Recette recette);


    Page<Recette> getRecettes(Pageable pageable);
}
