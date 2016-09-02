package co.dwsoftware.erp.gefi.controller;

import co.dwsoftware.erp.gefi.model.Member;
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

    @RequestMapping(value = "/member/", method = RequestMethod.POST)
    @ResponseBody
    @Transactional
    public Member createMember(@RequestBody Member member) {
        return memberService.create(member);
    }

    @RequestMapping(value = "/member/", method = RequestMethod.PUT)
    @ResponseBody
    @Transactional
    public Member updateMember(@RequestBody Member member) {
        return memberService.update(member);
    }

    @RequestMapping(value = "/member/", method = RequestMethod.GET)
    @ResponseBody
    @Transactional
    public List<Member> findAll() {
        return memberService.findAll();
    }
}
