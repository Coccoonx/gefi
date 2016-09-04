package co.dwsoftware.erp.gefi.controller;

import co.dwsoftware.erp.gefi.model.Aide;
import co.dwsoftware.erp.gefi.service.AideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by lyonnel on 02/09/16.
 */
@Controller
public class AideController {

    @Autowired
    AideService aideService;

    @RequestMapping(value = "/aide/", method = RequestMethod.POST)
    @ResponseBody
    @Transactional
    public Aide createAide(@RequestBody Aide aide) {
        return aideService.create(aide);
    }

    @RequestMapping(value = "/aide/", method = RequestMethod.PUT)
    @ResponseBody
    @Transactional
    public Aide updateAide(@RequestBody Aide aide) {
        return aideService.update(aide);
    }

    @RequestMapping(value = "/aide/", method = RequestMethod.GET)
    @ResponseBody
    @Transactional
    public List<Aide> findAll() {
        return aideService.findAll();
    }


    @RequestMapping(value = "/aide/{aideId}", method = RequestMethod.DELETE)
    @ResponseBody
    @Transactional
    public void deleteAide(@PathVariable long aideId) {
        aideService.delete(aideId);
    }
}
