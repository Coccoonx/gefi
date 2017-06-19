package co.dwsoftware.erp.gefi.service.impl;

import co.dwsoftware.erp.gefi.model.Annee;
import co.dwsoftware.erp.gefi.repository.AnneeRepository;
import co.dwsoftware.erp.gefi.service.AnneeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by lyonnel on 02/09/16.
 */
@Component
public class AnneeServiceImpl implements AnneeService {

    @Autowired
    AnneeRepository anneeRepository;

    @Override
    public Annee create(Annee annee) {
        return anneeRepository.save(annee);
    }

    @Override
    public Annee update(Annee annee) {
        Annee exist = anneeRepository.findOne(annee.getId());
        if (exist == null) {
            throw new IllegalArgumentException("This year doesn't exist");
        }
        return anneeRepository.save(annee);
    }

    @Override
    public Annee findByNom(String nom) {
        return anneeRepository.findByNom(nom);
    }

    @Override
    public List<Annee> findAll() {
        return (List<Annee>) anneeRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        Annee exist = anneeRepository.findOne(id);
        if (exist == null) {
            throw  new IllegalArgumentException("");

        }
        anneeRepository.delete(id);
    }

   // @PostConstruct
    private void populateAnnee(){
        Annee annee = new Annee();
        annee.setNom("2015");
        annee.setDateDebut("2015-10-25");
        annee.setDateFin("2016-10-25");
        anneeRepository.save(annee);

        annee = new Annee();
        annee.setNom("2016");
        annee.setDateDebut("2016-10-25");
        annee.setDateFin("2017-10-25");
        anneeRepository.save(annee);


    }
}
