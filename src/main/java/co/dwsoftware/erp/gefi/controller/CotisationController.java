package co.dwsoftware.erp.gefi.controller;

import co.dwsoftware.erp.gefi.model.Cotisation;
import co.dwsoftware.erp.gefi.service.CotisationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by lyonnel on 02/09/16.
 */
@Controller
public class CotisationController {

    @Autowired
    CotisationService cotisationService;

    @RequestMapping(value = "/cotisation/", method = RequestMethod.POST)
    @ResponseBody
    @Transactional
    public Cotisation createCotisation(@RequestBody Cotisation cotisation) {
        return cotisationService.create(cotisation);
    }

    @RequestMapping(value = "/cotisation/", method = RequestMethod.PUT)
    @ResponseBody
    @Transactional
    public Cotisation updateCotisation(@RequestBody Cotisation cotisation) {
        return cotisationService.update(cotisation);
    }

    @RequestMapping(value = "/cotisation/", method = RequestMethod.GET)
    @ResponseBody
    @Transactional
    public List<Cotisation> findAll() {
        return cotisationService.findAll();
    }


    @RequestMapping(value = "/cotisation/{cotisationId}", method = RequestMethod.DELETE)
    @ResponseBody
    @Transactional
    public void deleteCotisation(@PathVariable long cotisationId) {
        cotisationService.delete(cotisationId);
    }
}
