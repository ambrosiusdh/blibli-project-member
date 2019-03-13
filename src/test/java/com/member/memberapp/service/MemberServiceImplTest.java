package com.member.memberapp.service;

import com.member.memberapp.model.Member;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Mono;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberServiceImplTest {

    @Autowired
    private MemberServiceImpl memberService;

    private Member member1;
    private Member member2;
    private List<Member> members;

    @Before
    public void setUp() throws Exception {
        member1 = new Member(1,
                "ambro",
                "ambro",
                "Ambro",
                20,
                "ambro@ambro.id",
                "BINUS SQUARE");
        member2 = new Member(2,
                "ambros",
                "ambros",
                "Ambros",
                21,
                "ambros@ambros.id",
                "BINUS SQUARE");
        memberService.createMember(member1).block();
        memberService.createMember(member2).block();

        members = memberService.findAll().collectList().block();
    }

    @Test
    public void createMember() {
        assertEquals("Data harus 2", members.size(), 2);
        assertEquals("Data harus sama", member1, memberService.findById(1).block());
    }

    @Test
    public void findById() {

        assertNull("Data harus tidak tertemukan",memberService.findById(3).block());

        assertEquals("Data harus sama", memberService.findById(1).block(), member1);

    }

    @Test
    public void findAll() {
        assertEquals("List harus bersize 2", members.size(), 2);
    }

    @Test
    public void update() {
        Member temp = new Member(1,
                "david",
                "david",
                "David",
                20,
                "david@david.id",
                "BINUS SQUARE");
        memberService.update(temp).block();

        assertEquals("Member harus terupdate", temp, memberService.findById(1).block());
    }

    @Test
    public void delete() {
        memberService.delete(2).block();
        Mono<Member> temp = memberService.findById(2);
        assertNull("Member 2 harus terhapus", temp.block());

    }
}