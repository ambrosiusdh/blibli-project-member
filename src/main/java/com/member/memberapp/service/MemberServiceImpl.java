package com.member.memberapp.service;

import com.member.memberapp.model.Member;
import com.member.memberapp.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class MemberServiceImpl implements MemberService {

    private MemberRepository memberRepository;

    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public Mono<Member> createMember(Member member) {
        return memberRepository.save(member);
    }

    @Override
    public Mono<Member> findById(int id) {
        return memberRepository.findById(id);
    }

    @Override
    public Flux<Member> findAll() {
        return memberRepository.findAll();
    }

    @Override
    public Mono<Member> update(Member member) {
        return memberRepository.save(member);
    }

    @Override
    public Mono<Member> delete(int id) {
        return memberRepository.findById(id)
                .flatMap(data-> memberRepository.deleteById(id)
                        .thenReturn(data)
                );
    }
}
