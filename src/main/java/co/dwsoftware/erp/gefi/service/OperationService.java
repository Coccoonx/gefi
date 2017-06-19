package co.dwsoftware.erp.gefi.service;

import co.dwsoftware.erp.gefi.model.InscriptionAnnuelle;
import co.dwsoftware.erp.gefi.model.Operation;
import co.dwsoftware.erp.gefi.model.Service;

import java.util.List;


public interface OperationService {

    Operation create(Operation inscription);
    Operation update(Operation inscription);
    List<Operation> findAll();
    void delete(Long Id);
    
	List<Operation> findOpsAideByCotisation(long cotisationId);
	List<InscriptionAnnuelle> findMembreForRemboursementAide(long cotisationId, long operationId);
	List<Operation> findMembreRembourseurAide(long cotisationId, long operationId);

}
