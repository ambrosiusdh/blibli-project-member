package com.member.memberapp.service;

import com.member.memberapp.model.Member;
import org.junit.Before;
import org.junit.Test;
import org.springframework.stereotype.Component;

import static org.junit.Assert.*;

@Component
public class MemberServiceImplTest {

    private MemberServiceImpl memberService;
    private Member member1;
    private Member member2;

    @Before
    public void setUp() throws Exception {
        memberService = new MemberServiceImpl();
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
        memberService.createMember(member1);
        memberService.createMember(member2);
    }

    @Test
    public void createMember() {
        assertEquals("Data harus 2", memberService.findAll().size(), 2);

        Member temp = memberService.findById(1);
        assertEquals("Data harus sama", member1, temp);
    }

    @Test
    public void findById() {

        assertNull("Data harus tidak tertemukan",memberService.findById(3));

        assertEquals("Data harus sama", memberService.findById(1), member1);

    }

    @Test
    public void findAll() {
        assertEquals("List harus bersize 2", memberService.getMembers().size(), 2);
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
        memberService.update(temp);

        assertEquals("Member harus terupdate", temp, memberService.findById(1));
    }

    @Test
    public void delete() {
        memberService.delete(2);
        assertFalse("Member 2 harus terhapus", memberService.getMembers().contains(member2));

    }
}