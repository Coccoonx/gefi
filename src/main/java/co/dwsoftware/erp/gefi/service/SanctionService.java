package co.dwsoftware.erp.gefi.service;

import co.dwsoftware.erp.gefi.model.Sanction;

import java.util.List;

/**
 * Created by lyonnel on 02/09/16.
 */
public interface SanctionService {

    Sanction create(Sanction sanction);
    Sanction update(Sanction sanction);
    Sanction findByMotif(String motif);
    List<Sanction> findAll();
    void delete(Long Id);

}
