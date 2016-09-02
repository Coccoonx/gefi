package co.dwsoftware.erp.gefi.service.impl;

import co.dwsoftware.erp.gefi.model.Member;
import co.dwsoftware.erp.gefi.repository.MemberRepository;
import co.dwsoftware.erp.gefi.service.MemberService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by lyonnel on 02/09/16.
 */
@Component
public class MemberServiceImpl implements MemberService {

    @Autowired
    MemberRepository memberRepository;

    @Override
    public Member create(Member member) {
        return memberRepository.save(member);
    }

    @Override
    public Member update(Member member) {
        Member exist = memberRepository.findByLastName(member.getLastName());
        if (exist != null) {
            throw new IllegalArgumentException("");
        }
        return memberRepository.save(member);
    }

    @Override
    public Member findByLastName(String lastName) {
        return memberRepository.findByLastName(lastName);
    }

    @Override
    public List<Member> findAll() {
        return (List<Member>) memberRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        memberRepository.delete(id);
    }
}
