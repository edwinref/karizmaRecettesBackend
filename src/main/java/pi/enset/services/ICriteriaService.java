package pi.enset.services;

import pi.enset.entities.Criteria;

public interface ICriteriaService {
    Criteria save(Criteria criteria);
    Criteria getCriteriaByStud(Long id);
}
