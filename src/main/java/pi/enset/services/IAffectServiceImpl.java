package pi.enset.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pi.enset.entities.AffectationModuleGroupeTeacher;
import pi.enset.repository.AffectRepository;

@Service
public class IAffectServiceImpl implements IAffect{

    @Autowired
    AffectRepository affectRepository;

    @Override
    public AffectationModuleGroupeTeacher save(AffectationModuleGroupeTeacher affectationModuleGroupeTeacher) {
        return affectRepository.save(affectationModuleGroupeTeacher);
    }
}
