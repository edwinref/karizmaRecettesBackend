package karizma.recette.services;

import karizma.recette.entities.Etape;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEtapeService {

    List<Etape> getEtapes();

    Etape addEtape(Etape etape);

    String deleteEtape(Long id);

    Etape getEtapeById(Long id);

    Etape updateEtape(Long id, Etape etape);

    Page<Etape> getEtapes(Pageable pageable);

    Page<Etape> searchEtapes(String keyword, Pageable pageable);

}
