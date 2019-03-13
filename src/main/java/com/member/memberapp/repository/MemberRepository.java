package com.member.memberapp.repository;

import com.member.memberapp.model.Member;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MemberRepository extends ReactiveMongoRepository<Member, Integer> {

    Mono<Member> findByName(String name);

    Flux<Member> findAllByName(String name);

}
