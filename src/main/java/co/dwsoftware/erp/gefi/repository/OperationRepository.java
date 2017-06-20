package co.dwsoftware.erp.gefi.repository;

import co.dwsoftware.erp.gefi.model.*;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OperationRepository extends CrudRepository<Operation, Long> {

	@Query("SELECT o FROM Operation o where o.type = :type AND o.dateOperation = :dateOperation AND o.membre = :membre AND o.service = :service")
    Operation findExistingOperation(@Param("dateOperation") long dateOperation, @Param("membre") Membre membre, @Param("service") Service service, @Param("type") TypeOperation type);
	
	@Query("SELECT o FROM Operation o where o.type = 0")
    List<Operation> findAllAide();

	@Query("SELECT o FROM Operation o where o.type = 1 AND o.idOperationInitiale = :idOperationParent ")
    List<Operation> findAllRembourseurAide(@Param("idOperationParent") long idOperationParent);
	
	@Query("SELECT o FROM Operation o where o.type = 3")
    List<Operation> findAllRembourseurSanction();
	
	@Query("SELECT o FROM Operation o where o.type = 2")
    List<Operation> findAllSanction();
	


}
