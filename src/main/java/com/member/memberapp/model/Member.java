package com.member.memberapp.model;

import com.member.memberapp.validation.NotZero;
import com.member.memberapp.validation.UniqueName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "members")
public class Member {

    @Id
    private Integer memberId;

    @UniqueName
    @NotBlank
    private String username;

    @NotBlank
    private String password;

    @NotBlank
    private String name;

    @NotZero
    private int age;

    @UniqueName
    @NotBlank
    private String email;

    @NotBlank
    private String address;
}
