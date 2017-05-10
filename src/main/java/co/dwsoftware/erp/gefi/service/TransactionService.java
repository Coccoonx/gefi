package co.dwsoftware.erp.gefi.service;

import co.dwsoftware.erp.gefi.model.Cotisation;
import co.dwsoftware.erp.gefi.model.Transaction;

import java.util.List;


public interface TransactionService {

    Transaction create(Transaction inscription);
    Transaction update(Transaction inscription);
    List<Transaction> findAllTontineByCotisation(long cotisationId, long date);
    List<Transaction> findAll();
    void delete(Long Id);

}
