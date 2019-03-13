package com.member.memberapp.validation;

import com.member.memberapp.model.Member;
import com.member.memberapp.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueNameValidator implements ConstraintValidator<UniqueName, String> {

    private MemberRepository memberRepository;

    @Autowired
    public UniqueNameValidator(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if(value == null){
            return false;
        }

        Member product = memberRepository.findByName(value).block();

        return product == null;
    }
}
