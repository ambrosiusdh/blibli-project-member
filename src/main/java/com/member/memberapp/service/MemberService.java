package com.member.memberapp.service;

import com.member.memberapp.model.Member;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public interface MemberService {

    Mono<Member> createMember (Member member);
    Mono<Member> findById(int id);
    Flux<Member> findAll();
    Mono<Member> update(Member member);
    Mono<Member> delete(int id);

}
