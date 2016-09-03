package co.dwsoftware.erp.gefi.controller;

import co.dwsoftware.erp.gefi.model.Membre;
import co.dwsoftware.erp.gefi.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by lyonnel on 02/09/16.
 */
@Controller
public class MemberController {

    @Autowired
    MemberService memberService;

    @RequestMapping(value = "/membre/", method = RequestMethod.POST)
    @ResponseBody
    @Transactional
    public Membre createMember(@RequestBody Membre membre) {
        return memberService.create(membre);
    }

    @RequestMapping(value = "/membre/", method = RequestMethod.PUT)
    @ResponseBody
    @Transactional
    public Membre updateMember(@RequestBody Membre membre) {
        return memberService.update(membre);
    }

    @RequestMapping(value = "/membre/", method = RequestMethod.GET)
    @ResponseBody
    @Transactional
    public List<Membre> findAll() {
        return memberService.findAll();
    }


    @RequestMapping(value = "/membre/{memberId}", method = RequestMethod.DELETE)
    @ResponseBody
    @Transactional
    public void deleteMember(@PathVariable long memberId) {
        memberService.delete(memberId);
    }
}
