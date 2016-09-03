package co.dwsoftware.erp.gefi.service.impl;

import co.dwsoftware.erp.gefi.model.Membre;
import co.dwsoftware.erp.gefi.repository.MembreRepository;
import co.dwsoftware.erp.gefi.service.MemberService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by lyonnel on 02/09/16.
 */
@Component
public class MembreServiceImpl implements MemberService {

    @Autowired
    MembreRepository membreRepository;

    @Override
    public Membre create(Membre membre) {
        return membreRepository.save(membre);
    }

    @Override
    public Membre update(Membre membre) {
        Membre exist = membreRepository.findByNom(membre.getNom());
        if (exist != null) {
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
    public Membre findByNumeroCni(String numeroCni) {
        return membreRepository.findByAdresse(numeroCni);
    }

    @Override
    public List<Membre> findAll() {
        return (List<Membre>) membreRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        membreRepository.delete(id);
    }
}
