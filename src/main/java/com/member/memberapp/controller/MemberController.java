package com.member.memberapp.controller;

import com.member.memberapp.model.Member;
import com.member.memberapp.service.MemberServiceImpl;
import com.member.memberapp.validation.ValidationHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.List;

@RestController
public class MemberController {

    private MemberServiceImpl memberService;
    private ValidationHelper validationHelper;

    @Autowired
    public MemberController(MemberServiceImpl memberService, ValidationHelper validationHelper) {
        this.memberService = memberService;
        this.validationHelper = validationHelper;
    }

    @RequestMapping(
            value = "/member",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Mono<Member> createMember(@RequestBody Member member) {
        return validationHelper.validate(member)
                .flatMap(data-> memberService.createMember(data))
                .subscribeOn(Schedulers.elastic());
    }

    @RequestMapping(
            value = "/database/member/{memberId}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Mono<Member> findById(@PathVariable int memberId) {
        return memberService.findById(memberId);
    }

    @RequestMapping(
            value = "/database/member/all",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Flux<Member> findAll() {
        return memberService.findAll();
    }

    @RequestMapping(
            value = "/member",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Mono<Member> update(@RequestBody Member member) {
        return memberService.update(member);
    }

    @RequestMapping(
            value = "/member/{memberId}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Mono<Member> delete(@PathVariable int memberId) {
        return memberService.delete(memberId);
    }
}
