package co.dwsoftware.erp.gefi.service.impl;

import co.dwsoftware.erp.gefi.model.Aide;
import co.dwsoftware.erp.gefi.repository.AideRepository;
import co.dwsoftware.erp.gefi.service.AideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by lyonnel on 02/09/16.
 */
@Component
public class AideServiceImpl implements AideService {

    @Autowired
    AideRepository aideRepository;

    @Override
    public Aide create(Aide aide) {
        return aideRepository.save(aide);
    }

    @Override
    public Aide update(Aide aide) {
        Aide exist = aideRepository.findByMotif(aide.getMotif());
        if (exist == null) {
            throw new IllegalArgumentException("");
        }
        return aideRepository.save(exist);
    }

    @Override
    public Aide findByMotif(String motif) {
        return aideRepository.findByMotif(motif);
    }

    @Override
    public List<Aide> findAll() {
        return (List<Aide>) aideRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        Aide exist = aideRepository.findOne(id);
        if (exist == null) {
            throw  new IllegalArgumentException("");

        }
        aideRepository.delete(id);
    }
}
