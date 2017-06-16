package co.dwsoftware.erp.gefi.controller;

import co.dwsoftware.erp.gefi.model.Service;
import co.dwsoftware.erp.gefi.service.AideSanctionService;
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
    AideSanctionService aideSanctionService;

    @RequestMapping(value = "/service/", method = RequestMethod.POST)
    @ResponseBody
    @Transactional
    public Service createAide(@RequestBody Service service) {
        return aideSanctionService.create(service);
    }

    @RequestMapping(value = "/service/", method = RequestMethod.PUT)
    @ResponseBody
    @Transactional
    public Service updateAide(@RequestBody Service service) {
        return aideSanctionService.update(service);
    }

    @RequestMapping(value = "/service/", method = RequestMethod.GET)
    @ResponseBody
    @Transactional
    public List<Service> findAll() {
        return aideSanctionService.findAll();
    }


    @RequestMapping(value = "/service/{aideId}", method = RequestMethod.DELETE)
    @ResponseBody
    @Transactional
    public void deleteAide(@PathVariable long aideId) {
        aideSanctionService.delete(aideId);
    }
}
