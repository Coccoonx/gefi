package co.dwsoftware.erp.gefi.controller;

import co.dwsoftware.erp.gefi.model.Annee;
import co.dwsoftware.erp.gefi.model.Inscription;
import co.dwsoftware.erp.gefi.service.InscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by lyonnel on 02/09/16.
 */
@Controller
public class InscriptionController {

    @Autowired
    InscriptionService inscriptionService;

    @RequestMapping(value = "/inscription/", method = RequestMethod.POST)
    @ResponseBody
    @Transactional
    public Inscription createInscription(@RequestBody Inscription inscription) {
        return inscriptionService.create(inscription);
    }

    @RequestMapping(value = "/inscription/", method = RequestMethod.PUT)
    @ResponseBody
    @Transactional
    public Inscription updateInscription(@RequestBody Inscription inscription) {
        return inscriptionService.update(inscription);
    }

    @RequestMapping(value = "/inscription/", method = RequestMethod.GET)
    @ResponseBody
    @Transactional
    public List<Inscription> findAll() {
        return inscriptionService.findAll();
    }

    @RequestMapping(value = "/inscription/annee", method = RequestMethod.POST)
    @ResponseBody
    @Transactional
    public List<Inscription> findAllByAnnee(@RequestBody Annee annee) {
        return inscriptionService.findByAnnee(annee);
    }


    @RequestMapping(value = "/inscription/{inscriptionId}", method = RequestMethod.DELETE)
    @ResponseBody
    @Transactional
    public void deleteInscription(@PathVariable long inscriptionId) {
        inscriptionService.delete(inscriptionId);
    }
}
