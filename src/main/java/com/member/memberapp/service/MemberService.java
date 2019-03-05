package com.member.memberapp.service;

import com.member.memberapp.model.Member;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface MemberService {

    Member createMember (Member member);
    Member findById(int id);
    List<Member> findAll();
    Member update(Member member);
    Member delete(int id);

}
