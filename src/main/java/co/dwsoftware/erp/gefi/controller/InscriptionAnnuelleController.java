package co.dwsoftware.erp.gefi.controller;

import co.dwsoftware.erp.gefi.model.Cotisation;
import co.dwsoftware.erp.gefi.model.InscriptionAnnuelle;
import co.dwsoftware.erp.gefi.service.InscriptionAnnuelleService;
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
public class InscriptionAnnuelleController {

    @Autowired
    InscriptionAnnuelleService inscriptionService;

    @RequestMapping(value = "/annuelle/", method = RequestMethod.POST)
    @ResponseBody
    @Transactional
    public InscriptionAnnuelle createInscription(@RequestBody InscriptionAnnuelle inscription) {
        return inscriptionService.create(inscription);
    }

    @RequestMapping(value = "/annuelle/", method = RequestMethod.PUT)
    @ResponseBody
    @Transactional
    public InscriptionAnnuelle updateInscription(@RequestBody InscriptionAnnuelle inscription) {
        return inscriptionService.update(inscription);
    }

    @RequestMapping(value = "/annuelle/", method = RequestMethod.GET)
    @ResponseBody
    @Transactional
    public List<InscriptionAnnuelle> findAll() {
        return inscriptionService.findAll();
    }

    @RequestMapping(value = "/annuelle/element", method = RequestMethod.POST)
    @ResponseBody
    @Transactional
    public List<InscriptionAnnuelle> findAllByCotisation(@RequestBody Cotisation annuelle) {
        return inscriptionService.findByCotisation(annuelle);
    }


    @RequestMapping(value = "/annuelle/{inscriptionId}", method = RequestMethod.DELETE)
    @ResponseBody
    @Transactional
    public void deleteInscription(@PathVariable long inscriptionId) {
        inscriptionService.delete(inscriptionId);
    }
}
