package co.dwsoftware.erp.gefi.service;

import co.dwsoftware.erp.gefi.model.Aide;

import java.util.List;

/**
 * Created by lyonnel on 02/09/16.
 */
public interface AideService {

    Aide create(Aide aide);
    Aide update(Aide aide);
    Aide findByMotif(String motif);
    List<Aide> findAll();
    void delete(Long Id);

}
