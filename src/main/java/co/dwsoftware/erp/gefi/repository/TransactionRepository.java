package co.dwsoftware.erp.gefi.repository;

import co.dwsoftware.erp.gefi.model.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TransactionRepository extends CrudRepository<Transaction, Long> {


	List<Transaction> findByCotisation(@Param("cotisation") Cotisation cotisation);
	
	@Query("SELECT t FROM Transaction t WHERE t.cotisation = :cotisation AND t.dateOperation = :dateOperation AND t.type = 1")
    List<Transaction> findAllTontinesByCotisationAndDateOperation(@Param("cotisation") Cotisation cotisation, @Param("dateOperation") long dateOperation);

    @Query("SELECT t FROM Transaction t WHERE t.membre = :membre AND t.cotisation = :cotisation ")
    Transaction findByMembreAndCotisation(@Param("membre") Membre membre, @Param("cotisation") Cotisation cotisation);
    
    @Query("SELECT t FROM Transaction t WHERE t.membre = :membre AND t.cotisation = :cotisation AND t.dateOperation = :dateOperation")
    Transaction findByMembreAndCotisationAndDate(@Param("membre") Membre membre, @Param("cotisation") Cotisation cotisation, @Param("dateOperation") long dateOperation);

}
