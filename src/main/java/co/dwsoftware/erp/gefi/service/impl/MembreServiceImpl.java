package co.dwsoftware.erp.gefi.service.impl;

import co.dwsoftware.erp.gefi.model.Membre;
import co.dwsoftware.erp.gefi.repository.MembreRepository;
import co.dwsoftware.erp.gefi.service.MembreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by lyonnel on 02/09/16.
 */
@Component
public class MembreServiceImpl implements MembreService {

    @Autowired
    MembreRepository membreRepository;

    @Override
    public Membre create(Membre membre) {
        Membre exist = membreRepository.findOne(membre.getId());
        if (exist != null) {
            throw new IllegalArgumentException("");
        }
        return membreRepository.save(membre);
    }

    @Override
    public Membre update(Membre membre) {
        Membre exist = membreRepository.findOne(membre.getId());
        if (exist == null) {
            throw new IllegalArgumentException("");
        }
        return membreRepository.save(membre);
    }

    @Override
    public Membre findByNom(String lastName) {
        return membreRepository.findByNom(lastName);
    }

    @Override
    public Membre findByPrenom(String prenom) {
        return membreRepository.findByPrenom(prenom);
    }

    @Override
    public Membre findByAdresse(String adresse) {
        return membreRepository.findByAdresse(adresse);
    }

    @Override
    public Membre findByCni(String numeroCni) {
        return membreRepository.findByCni(numeroCni);
    }

    @Override
    public List<Membre> findAll() {
        return (List<Membre>) membreRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        membreRepository.delete(id);
    }

    //@PostConstruct
    public void populate(){
        Membre membre = new Membre();
        membre.setNom("Kamga");
        membre.setPrenom("Maurice");
        membre.setAdresse("Makepe");
        membre.setCni("125548518");
        membre.setTelephone("688778899");
        membreRepository.save(membre);

        membre = new Membre();
        membre.setNom("Kemogne");
        membre.setPrenom("Jean");
        membre.setAdresse("Makepe");
        membre.setCni("125548518");
        membre.setTelephone("688778899");
        membreRepository.save(membre);
    }
}
