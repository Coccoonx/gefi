package co.dwsoftware.erp.gefi.service.impl;

import co.dwsoftware.erp.gefi.model.Cotisation;
import co.dwsoftware.erp.gefi.model.Type;
import co.dwsoftware.erp.gefi.repository.CotisationRepository;
import co.dwsoftware.erp.gefi.service.CotisationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by lyonnel on 02/09/16.
 */
@Component
public class CotisationServiceImpl implements CotisationService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CotisationRepository cotisationRepository;

    @Override
    public Cotisation create(Cotisation cotisation) {
        return cotisationRepository.save(cotisation);
    }

    @Override
    public Cotisation update(Cotisation cotisation) {
        Cotisation exist = cotisationRepository.findOne(cotisation.getId());
        if (exist == null) {
            throw new IllegalArgumentException("Element does not exist");

        }
        return cotisationRepository.save(cotisation);
    }

    @Override
    public Cotisation findByNom(String nom) {
        return cotisationRepository.findByNom(nom);
    }

    @Override
    public List<Cotisation> findByTontine() {

        logger.info("get all tontine");

        return cotisationRepository.findByTontine();


    }

    @Override
    public List<Cotisation> findByEpargne() {

        logger.info("get all tontine");

        return cotisationRepository.findByEpargne();


    }

    @Override
    public Cotisation findByAnnee(String annee) {
        return cotisationRepository.findByAnnee(annee);
    }

    @Override
    public List<Cotisation> findAll() {
        return (List<Cotisation>) cotisationRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        Cotisation exist = cotisationRepository.findOne(id);
        if (exist == null) {
            throw new IllegalArgumentException("");

        }
        cotisationRepository.delete(id);
    }

    @PostConstruct
    private void populateAnnee() {
        Cotisation cotisation = new Cotisation();
        cotisation.setNom("Inscription 2000");
        cotisation.setMontant(2000.0);
        cotisation.setDateDebut("2016-10-12");
        cotisation.setDateFin("2017-10-11");
        cotisation.setType(Type.TONTINE);
        cotisation.setAnnee("2015");
        cotisationRepository.save(cotisation);

        cotisation = new Cotisation();
        cotisation.setNom("Inscription 50000");
        cotisation.setMontant(50000.0);
        cotisation.setDateDebut("2016-10-13");
        cotisation.setDateFin("2017-10-12");
        cotisation.setType(Type.TONTINE);
        cotisation.setAnnee("2016");
        cotisationRepository.save(cotisation);

        cotisation = new Cotisation();
        cotisation.setNom("Epargne");
        cotisation.setDateDebut("2016-10-15");
        cotisation.setDateFin("2017-10-14");
        cotisation.setType(Type.EPARGNE);
        cotisation.setAnnee("2016");
        cotisationRepository.save(cotisation);
        
        cotisation = new Cotisation();
        cotisation.setNom("Cotisation Annuelle");
        cotisation.setDateDebut("2016-10-15");
        cotisation.setDateFin("2017-10-14");
        cotisation.setType(Type.ANNEE);
        cotisation.setAnnee("2016");
        cotisationRepository.save(cotisation);
    }
}
