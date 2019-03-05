package com.member.memberapp.controller;

import com.member.memberapp.model.Member;
import com.member.memberapp.service.MemberServiceImpl;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MemberController {

    private MemberServiceImpl memberService;

    public MemberController(MemberServiceImpl memberService) {
        this.memberService = memberService;
    }

    @RequestMapping(
            value = "/member",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Member createMember(@RequestBody Member member) {
        memberService.createMember(member);
        return member;
    }

    @RequestMapping(
            value = "/member/{memberId}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Member findById(@PathVariable int memberId) {
        return memberService.findById(memberId);
    }

    @RequestMapping(
            value = "/member",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Member> findAll() {
        return memberService.getMembers();
    }

    @RequestMapping(
            value = "/member",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Member update(@RequestBody Member member) {
        return memberService.update(member);
    }

    @RequestMapping(
            value = "/member/{memberId}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Member delete(@PathVariable int memberId) {
        return memberService.delete(memberId);
    }
}
