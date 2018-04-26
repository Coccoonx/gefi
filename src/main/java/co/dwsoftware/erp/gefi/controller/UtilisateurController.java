package co.dwsoftware.erp.gefi.controller;

import co.dwsoftware.erp.gefi.model.Utilisateur;
import co.dwsoftware.erp.gefi.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by lyonnel on 02/09/16.
 */
@Controller
public class UtilisateurController {

    @Autowired
    UtilisateurService utilisateurService;

    @RequestMapping(value = "/utilisateur/", method = RequestMethod.POST)
    @ResponseBody
    @Transactional
    public Utilisateur createUtilisateur(@RequestBody Utilisateur utilisateur) {
        return utilisateurService.create(utilisateur);
    }

    @RequestMapping(value = "/utilisateur/", method = RequestMethod.PUT)
    @ResponseBody
    @Transactional
    public Utilisateur updateUtilisateur(@RequestBody Utilisateur utilisateur) {
        return utilisateurService.update(utilisateur);
    }

    @RequestMapping(value = "/utilisateur/", method = RequestMethod.GET)
    @ResponseBody
    @Transactional
    public List<Utilisateur> findAll() {
        return utilisateurService.findAll();
    }


    @RequestMapping(value = "/utilisateur/{memberId}", method = RequestMethod.DELETE)
    @ResponseBody
    @Transactional
    public void deleteUtilisateur(@PathVariable long memberId) {
        utilisateurService.delete(memberId);
    }
}
