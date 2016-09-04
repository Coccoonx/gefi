package co.dwsoftware.erp.gefi.controller;

import co.dwsoftware.erp.gefi.model.Membre;
import co.dwsoftware.erp.gefi.service.MembreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by lyonnel on 02/09/16.
 */
@Controller
public class MembreController {

    @Autowired
    MembreService membreService;

    @RequestMapping(value = "/membre/", method = RequestMethod.POST)
    @ResponseBody
    @Transactional
    public Membre createMembre(@RequestBody Membre membre) {
        return membreService.create(membre);
    }

    @RequestMapping(value = "/membre/", method = RequestMethod.PUT)
    @ResponseBody
    @Transactional
    public Membre updateMembre(@RequestBody Membre membre) {
        return membreService.update(membre);
    }

    @RequestMapping(value = "/membre/", method = RequestMethod.GET)
    @ResponseBody
    @Transactional
    public List<Membre> findAll() {
        return membreService.findAll();
    }


    @RequestMapping(value = "/membre/{memberId}", method = RequestMethod.DELETE)
    @ResponseBody
    @Transactional
    public void deleteMembre(@PathVariable long memberId) {
        membreService.delete(memberId);
    }
}
