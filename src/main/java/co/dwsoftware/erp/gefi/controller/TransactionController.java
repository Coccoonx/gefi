package co.dwsoftware.erp.gefi.controller;

import co.dwsoftware.erp.gefi.model.Cotisation;
import co.dwsoftware.erp.gefi.model.Transaction;
import co.dwsoftware.erp.gefi.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by lyonnel on 02/09/16.
 */
@Controller
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @RequestMapping(value = "/transaction/", method = RequestMethod.POST)
    @ResponseBody
    @Transactional
    public Transaction createTransaction(@RequestBody Transaction transaction) {
        return transactionService.create(transaction);
    }

    @RequestMapping(value = "/transaction/", method = RequestMethod.PUT)
    @ResponseBody
    @Transactional
    public Transaction updateTransaction(@RequestBody Transaction transaction) {
        return transactionService.update(transaction);
    }

    @RequestMapping(value = "/transaction/", method = RequestMethod.GET)
    @ResponseBody
    @Transactional
    public List<Transaction> findAll() {
        return transactionService.findAll();
    }

    @RequestMapping(value = "/transaction/cotisation/tontiner", method = RequestMethod.POST)
    @ResponseBody
    @Transactional
    public List<Transaction> findAllByCotisation(@RequestBody Cotisation cotisation, String date) {
        return transactionService.findAllTontineByCotisation(cotisation, Long.parseLong(date));
    }


    @RequestMapping(value = "/transaction/{transactionId}", method = RequestMethod.DELETE)
    @ResponseBody
    @Transactional
    public void deleteTransaction(@PathVariable long transactionId) {
        transactionService.delete(transactionId);
    }
}
