package co.dwsoftware.erp.gefi.repository;

import co.dwsoftware.erp.gefi.model.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TransactionRepository extends CrudRepository<Transaction, Long> {


	List<Transaction> findByCotisation(@Param("cotisation") Cotisation cotisation);
	
	@Query("SELECT t FROM Transaction t WHERE t.dateTransaction = :dateTransaction AND t.type = 1")
    List<Transaction> findAllWinneableTontineByDate(@Param("dateTransaction") long dateTransaction);
	
	
	@Query("SELECT t FROM Transaction t WHERE t.cotisation = :cotisation AND t.dateTransaction = :dateTransaction AND t.type = 0")
    List<Transaction> findAllBeneficesByCotisationAndDateTransaction(@Param("cotisation") Cotisation cotisation, @Param("dateTransaction") long dateTransaction);
	
	@Query("SELECT t FROM Transaction t WHERE t.cotisation = :cotisation AND t.dateTransaction = :dateTransaction AND t.type = 1")
    List<Transaction> findAllTontinesByCotisationAndDateTransaction(@Param("cotisation") Cotisation cotisation, @Param("dateTransaction") long dateTransaction);
	
	@Query("SELECT t FROM Transaction t WHERE t.cotisation = :cotisation AND t.dateTransaction = :dateTransaction AND t.type = 2")
    List<Transaction> findAllPretsByCotisationAndDateTransaction(@Param("cotisation") Cotisation cotisation, @Param("dateTransaction") long dateTransaction);
	
	@Query("SELECT t FROM Transaction t WHERE t.cotisation = :cotisation AND t.type = 2")
    List<Transaction> findAllPretsSuiviByCotisation(@Param("cotisation") Cotisation cotisation);
	
	@Query("SELECT t FROM Transaction t WHERE t.cotisation = :cotisation AND t.type = 3")
    List<Transaction> findAllRemboursementsSuiviByCotisation(@Param("cotisation") Cotisation cotisation);
	
	@Query("SELECT t FROM Transaction t WHERE t.cotisation = :cotisation AND t.dateTransaction = :dateTransaction AND t.type = 3")
    List<Transaction> findAllRemboursementsByCotisationAndDateTransaction(@Param("cotisation") Cotisation cotisation, @Param("dateTransaction") long dateTransaction);
	
	@Query("SELECT t FROM Transaction t WHERE t.cotisation = :cotisation AND t.type = 2")
    List<Transaction> findAllRemboursementsByCotisation(@Param("cotisation") Cotisation cotisation);
	
	@Query("SELECT t FROM Transaction t WHERE t.cotisation = :cotisation AND t.dateTransaction = :dateTransaction AND t.type = 4")
    List<Transaction> findAllEpargnesByCotisationAndDateTransaction(@Param("cotisation") Cotisation cotisation, @Param("dateTransaction") long dateTransaction);
	
	@Query("SELECT t FROM Transaction t WHERE t.cotisation = :cotisation AND t.membre = :membre  AND t.type = 4")
    List<Transaction> findAllEpargnesByCotisationAndMembre(@Param("cotisation") Cotisation cotisation, @Param("membre") Membre membre);
	
	@Query("SELECT t FROM Transaction t WHERE t.cotisation = :cotisation AND t.type = 4")
    List<Transaction> findAllEpargnesByCotisation(@Param("cotisation") Cotisation cotisation);


    @Query("SELECT t FROM Transaction t WHERE t.membre = :membre AND t.cotisation = :cotisation ")
    Transaction findByMembreAndCotisation(@Param("membre") Membre membre, @Param("cotisation") Cotisation cotisation);
    
    @Query("SELECT t FROM Transaction t WHERE t.membre = :membre AND t.cotisation = :cotisation AND t.dateTransaction = :dateTransaction AND t.type = :type")
    Transaction findByMembreAndCotisationAndDateAndType(@Param("membre") Membre membre, @Param("cotisation") Cotisation cotisation, @Param("dateTransaction") long dateTransaction, @Param("type") TypeTransaction type);

}
