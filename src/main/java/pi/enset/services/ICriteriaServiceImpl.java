package pi.enset.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pi.enset.entities.Criteria;
import pi.enset.repository.CriteriaRepository;

@Service
public class ICriteriaServiceImpl implements ICriteriaService{

    @Autowired
    CriteriaRepository criteriaRepository;

    @Override
    public Criteria save(Criteria criteria) {
        return criteriaRepository.save(criteria);
    }

    @Override
    public Criteria getCriteriaByStud(Long id) {
        return criteriaRepository.getCriteriaByEtudiant(id);
    }
}
