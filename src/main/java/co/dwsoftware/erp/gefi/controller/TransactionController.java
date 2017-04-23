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
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @RequestMapping(value = "/cotisation/", method = RequestMethod.POST)
    @ResponseBody
    @Transactional
    public Transaction createTransaction(@RequestBody Transaction inscription) {
        return transactionService.create(inscription);
    }

    @RequestMapping(value = "/cotisation/", method = RequestMethod.PUT)
    @ResponseBody
    @Transactional
    public Transaction updateTransaction(@RequestBody Transaction inscription) {
        return transactionService.update(inscription);
    }

    @RequestMapping(value = "/cotisation/", method = RequestMethod.GET)
    @ResponseBody
    @Transactional
    public List<Transaction> findAll() {
        return transactionService.findAll();
    }

    @RequestMapping(value = "/cotisation/element", method = RequestMethod.POST)
    @ResponseBody
    @Transactional
    public List<Transaction> findAllByCotisation(@RequestBody Cotisation cotisation) {
        return transactionService.findByCotisation(cotisation);
    }


    @RequestMapping(value = "/cotisation/{inscriptionId}", method = RequestMethod.DELETE)
    @ResponseBody
    @Transactional
    public void deleteTransaction(@PathVariable long transactionId) {
        transactionService.delete(transactionId);
    }
}
