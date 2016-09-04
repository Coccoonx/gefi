package co.dwsoftware.erp.gefi.controller;

import co.dwsoftware.erp.gefi.model.Annee;
import co.dwsoftware.erp.gefi.service.AnneeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by lyonnel on 02/09/16.
 */
@Controller
public class AnneeController {

    @Autowired
    AnneeService anneeService;

    @RequestMapping(value = "/annee/", method = RequestMethod.POST)
    @ResponseBody
    @Transactional
    public Annee createAnnee(@RequestBody Annee annee) {
        return anneeService.create(annee);
    }

    @RequestMapping(value = "/annee/", method = RequestMethod.PUT)
    @ResponseBody
    @Transactional
    public Annee updateAnnee(@RequestBody Annee annee) {
        return anneeService.update(annee);
    }

    @RequestMapping(value = "/annee/", method = RequestMethod.GET)
    @ResponseBody
    @Transactional
    public List<Annee> findAll() {
        return anneeService.findAll();
    }


    @RequestMapping(value = "/annee/{anneeId}", method = RequestMethod.DELETE)
    @ResponseBody
    @Transactional
    public void deleteAnnee(@PathVariable long anneeId) {
        anneeService.delete(anneeId);
    }
}
