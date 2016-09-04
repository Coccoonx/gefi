package co.dwsoftware.erp.gefi.service.impl;

import co.dwsoftware.erp.gefi.model.Sanction;
import co.dwsoftware.erp.gefi.repository.SanctionRepository;
import co.dwsoftware.erp.gefi.service.SanctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by lyonnel on 02/09/16.
 */
@Component
public class SanctionServiceImpl implements SanctionService {

    @Autowired
    SanctionRepository sanctionRepository;

    @Override
    public Sanction create(Sanction aide) {
        return sanctionRepository.save(aide);
    }

    @Override
    public Sanction update(Sanction aide) {
        Sanction exist = sanctionRepository.findByMotif(aide.getMotif());
        if (exist == null) {
            throw new IllegalArgumentException("");
        }
        return sanctionRepository.save(exist);
    }

    @Override
    public Sanction findByMotif(String motif) {
        return sanctionRepository.findByMotif(motif);
    }


    @Override
    public List<Sanction> findAll() {
        return (List<Sanction>) sanctionRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        Sanction exist = sanctionRepository.findOne(id);
        if (exist == null) {
            throw  new IllegalArgumentException("");

        }
        sanctionRepository.delete(id);
    }

    @PostConstruct
    private void populate(){
        Sanction sanction = new Sanction();
        sanction.setMotif("Absence");
        sanctionRepository.save(sanction);

        sanction = new Sanction();
        sanction.setMotif("Retard");
        sanctionRepository.save(sanction);
    }
}
