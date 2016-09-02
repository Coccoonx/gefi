package co.dwsoftware.erp.gefi.service;

import co.dwsoftware.erp.gefi.model.Member;

import java.util.List;

/**
 * Created by lyonnel on 02/09/16.
 */
public interface MemberService {

    Member create(Member member);
    Member update(Member member);
    Member findByLastName(String lastName);
    List<Member> findAll();
    void delete(Long Id);

}
