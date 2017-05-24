package co.dwsoftware.erp.gefi.repository;

import co.dwsoftware.erp.gefi.model.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TransactionRepository extends CrudRepository<Transaction, Long> {


	List<Transaction> findByCotisation(@Param("cotisation") Cotisation cotisation);
	
	@Query("SELECT t FROM Transaction t WHERE t.dateOperation = :dateOperation AND t.type = 1")
    List<Transaction> findAllWinneableTontineByDate(@Param("dateOperation") long dateOperation);
	
	
	@Query("SELECT t FROM Transaction t WHERE t.cotisation = :cotisation AND t.dateOperation = :dateOperation AND t.type = 0")
    List<Transaction> findAllBeneficesByCotisationAndDateOperation(@Param("cotisation") Cotisation cotisation, @Param("dateOperation") long dateOperation);
	
	@Query("SELECT t FROM Transaction t WHERE t.cotisation = :cotisation AND t.dateOperation = :dateOperation AND t.type = 1")
    List<Transaction> findAllTontinesByCotisationAndDateOperation(@Param("cotisation") Cotisation cotisation, @Param("dateOperation") long dateOperation);
	
	@Query("SELECT t FROM Transaction t WHERE t.cotisation = :cotisation AND t.dateOperation = :dateOperation AND t.type = 2")
    List<Transaction> findAllPretsByCotisationAndDateOperation(@Param("cotisation") Cotisation cotisation, @Param("dateOperation") long dateOperation);
	
	@Query("SELECT t FROM Transaction t WHERE t.cotisation = :cotisation AND t.dateOperation = :dateOperation AND t.type = 3")
    List<Transaction> findAllRemboursementsByCotisationAndDateOperation(@Param("cotisation") Cotisation cotisation, @Param("dateOperation") long dateOperation);
	
	@Query("SELECT t FROM Transaction t WHERE t.cotisation = :cotisation AND t.dateOperation = :dateOperation AND t.type = 4")
    List<Transaction> findAllEpargnesByCotisationAndDateOperation(@Param("cotisation") Cotisation cotisation, @Param("dateOperation") long dateOperation);
	
	@Query("SELECT t FROM Transaction t WHERE t.cotisation = :cotisation AND t.membre = :membre  AND t.type = 4")
    List<Transaction> findAllEpargnesByCotisationAndMembre(@Param("cotisation") Cotisation cotisation, @Param("membre") Membre membre);
	
	@Query("SELECT t FROM Transaction t WHERE t.cotisation = :cotisation AND t.type = 4")
    List<Transaction> findAllEpargnesByCotisation(@Param("cotisation") Cotisation cotisation);


    @Query("SELECT t FROM Transaction t WHERE t.membre = :membre AND t.cotisation = :cotisation ")
    Transaction findByMembreAndCotisation(@Param("membre") Membre membre, @Param("cotisation") Cotisation cotisation);
    
    @Query("SELECT t FROM Transaction t WHERE t.membre = :membre AND t.cotisation = :cotisation AND t.dateOperation = :dateOperation AND t.type = :type")
    Transaction findByMembreAndCotisationAndDateAndType(@Param("membre") Membre membre, @Param("cotisation") Cotisation cotisation, @Param("dateOperation") long dateOperation, @Param("type") TypeTransaction type);

}
