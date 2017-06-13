package co.dwsoftware.erp.gefi.service;

import co.dwsoftware.erp.gefi.model.Transaction;

import java.util.List;


public interface TransactionService {

    Transaction create(Transaction inscription);
    Transaction update(Transaction inscription);
    List<Transaction> findAllWinneableTontineByDate(long date);
    List<Transaction> findAllTontineByCotisationAndDate(long cotisationId, long date);
    List<Transaction> findAllBeneficeByCotisationAndDate(long cotisationId, long date);
    List<Transaction> findAllPretByCotisationAndDate(long cotisationId, long date);
    List<Transaction> findAllPretSuiviByCotisation(long cotisationId);
    List<Transaction> findAllRemboursementSuiviByCotisation(long cotisationId);
    List<Transaction> findAllRemboursementByCotisationAndDate(long cotisationId, long date);
    List<Transaction> findAllRemboursementByCotisation(long cotisationId);
    List<Transaction> findAllEpargneByCotisationAndMembre(long cotisationId, long membreId);
    List<Transaction> findAllEpargneByCotisation(long cotisationId);
    List<Transaction> findAllEpargneByCotisationSuivi(long cotisationId);
    List<Transaction> findAll();
    void delete(Long Id);

}
