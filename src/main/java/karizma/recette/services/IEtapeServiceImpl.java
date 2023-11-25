package karizma.recette.services;

import karizma.recette.repository.EtapeRepository;
import karizma.recette.entities.Etape;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class IEtapeServiceImpl implements IEtapeService {
    private EtapeRepository etapeRepository;

    @Override
    public List<Etape> getEtapes() {
        return etapeRepository.findAll();
    }

    @Override
    public Etape addEtape(Etape etape) {

        return etapeRepository.save(etape);
    }

    @Override
    public String deleteEtape(Long id) {
        try {
            getEtapeById(id);
            etapeRepository.deleteById(id);
            return "Votre supression est effectuée avec succès";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public Etape getEtapeById(Long id) {
        return etapeRepository.findById(id).orElseThrow(() -> new RuntimeException("La filière n'existe pas!"));
    }

    @Override
    public Etape updateEtape(Long id, Etape etape) {
        etape.setId(id);
        return etapeRepository.save(etape);
    }

    @Override
    public Page<Etape> getEtapes(Pageable pageable) {
        return etapeRepository.findAll(pageable);
    }

    @Override
    public Page<Etape> searchEtapes(String keyword, Pageable pageable) {
        return etapeRepository.searchEtapes(keyword, pageable);
    }

}
