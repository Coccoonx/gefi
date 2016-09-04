package co.dwsoftware.erp.gefi.controller;

import co.dwsoftware.erp.gefi.model.Sanction;
import co.dwsoftware.erp.gefi.service.SanctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by lyonnel on 02/09/16.
 */
@Controller
public class SanctionController {

    @Autowired
    SanctionService sanctionService;

    @RequestMapping(value = "/sanction/", method = RequestMethod.POST)
    @ResponseBody
    @Transactional
    public Sanction createSanction(@RequestBody Sanction sanction) {
        return sanctionService.create(sanction);
    }

    @RequestMapping(value = "/sanction/", method = RequestMethod.PUT)
    @ResponseBody
    @Transactional
    public Sanction updateSanction(@RequestBody Sanction sanction) {
        return sanctionService.update(sanction);
    }

    @RequestMapping(value = "/sanction/", method = RequestMethod.GET)
    @ResponseBody
    @Transactional
    public List<Sanction> findAll() {
        return sanctionService.findAll();
    }

    @RequestMapping(value = "/sanction/{sanctionId}", method = RequestMethod.DELETE)
    @ResponseBody
    @Transactional
    public void deleteSanction(@PathVariable long sanctionId) {
        sanctionService.delete(sanctionId);
    }
}
