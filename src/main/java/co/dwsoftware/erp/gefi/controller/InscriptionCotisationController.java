package co.dwsoftware.erp.gefi.controller;

import co.dwsoftware.erp.gefi.model.Cotisation;
import co.dwsoftware.erp.gefi.model.InscriptionCotisation;
import co.dwsoftware.erp.gefi.service.InscriptionCotisationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by lyonnel on 02/09/16.
 */
@Controller
@RequestMapping("/inscription")
public class InscriptionCotisationController {

    @Autowired
    InscriptionCotisationService inscriptionService;

    @RequestMapping(value = "/cotisation/", method = RequestMethod.POST)
    @ResponseBody
    @Transactional
    public InscriptionCotisation createInscription(@RequestBody InscriptionCotisation inscription) {
        return inscriptionService.create(inscription);
    }

    @RequestMapping(value = "/cotisation/", method = RequestMethod.PUT)
    @ResponseBody
    @Transactional
    public InscriptionCotisation updateInscription(@RequestBody InscriptionCotisation inscription) {
        return inscriptionService.update(inscription);
    }

    @RequestMapping(value = "/cotisation/", method = RequestMethod.GET)
    @ResponseBody
    @Transactional
    public List<InscriptionCotisation> findAll() {
        return inscriptionService.findAll();
    }

    @RequestMapping(value = "/cotisation/element", method = RequestMethod.POST)
    @ResponseBody
    @Transactional
    public List<InscriptionCotisation> findAllByCotisation(@RequestBody Cotisation cotisation) {
        return inscriptionService.findByCotisation(cotisation);
    }


    @RequestMapping(value = "/cotisation/{inscriptionId}", method = RequestMethod.DELETE)
    @ResponseBody
    @Transactional
    public void deleteInscription(@PathVariable long inscriptionId) {
        inscriptionService.delete(inscriptionId);
    }
}
