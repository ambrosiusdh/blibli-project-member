package com.member.memberapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {

    private int memberId;
    private String username;
    private String password;
    private String name;
    private int age;
    private String email;
    private String address;
}
