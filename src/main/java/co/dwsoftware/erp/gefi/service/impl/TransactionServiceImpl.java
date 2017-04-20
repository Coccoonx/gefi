package co.dwsoftware.erp.gefi.service.impl;

import co.dwsoftware.erp.gefi.model.Cotisation;
import co.dwsoftware.erp.gefi.model.Transaction;
import co.dwsoftware.erp.gefi.repository.TransactionRepository;
import co.dwsoftware.erp.gefi.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by lyonnel on 02/09/16.
 */
@Component
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Override
    public Transaction create(Transaction transaction) {

        Transaction exist = transactionRepository.findByMembreAndCotisation(transaction.getMembre(), transaction.getCotisation());
        if (exist != null) {
            throw new IllegalArgumentException("transaction already exists");
        }

        Transaction saved  = transactionRepository.save(transaction);

        return saved;
    }

    @Override
    public Transaction update(Transaction transaction) {
        Transaction exist = transactionRepository.findByMembreAndCotisation(transaction.getMembre(), transaction.getCotisation());
        if (exist == null) {
            throw new IllegalArgumentException("transaction doesn't exist");
        }

        Transaction saved  = transactionRepository.save(transaction);

        return saved;
    }

    @Override
    public List<Transaction> findByCotisation (Cotisation cotisation) {
        return transactionRepository.findByCotisation(cotisation);
    }

    @Override
    public List<Transaction> findAll() {
        return (List<Transaction>) transactionRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        Transaction exist = transactionRepository.findOne(id);
        if (exist == null) {
            throw new IllegalArgumentException("transaction doesn't exist");
        }

        transactionRepository.delete(id);
    }
}
