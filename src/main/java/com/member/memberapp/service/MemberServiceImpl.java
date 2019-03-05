package com.member.memberapp.service;

import com.member.memberapp.model.Member;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MemberServiceImpl implements MemberService {

    private List<Member> members = new ArrayList<>();

    public List<Member> getMembers() {
        return members;
    }

    @Override
    public Member createMember(Member member) {
        members.add(member);
        return member;
    }

    @Override
    public Member findById(int id) {
        for (Member m: members) {
            if(m.getMemberId() == id){
                return m;
            }
        }
        return null;
    }

    @Override
    public List<Member> findAll() {
        return members;
    }

    @Override
    public Member update(Member member) {
        for (Member m : members) {
            if(m.getMemberId() == member.getMemberId()){
                BeanUtils.copyProperties(member, m);
                return m;
            }
        }
        return null;
    }

    @Override
    public Member delete(int id) {
        Member temp = new Member();
        for (Member m : members) {
            if(m.getMemberId() == id){
                BeanUtils.copyProperties(m, temp);
                members.remove(m);
                return temp;
            }
        }
        return null;
    }
}
