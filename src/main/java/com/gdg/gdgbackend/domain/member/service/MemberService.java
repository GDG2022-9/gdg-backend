package com.gdg.gdgbackend.domain.member.service;

import com.gdg.gdgbackend.domain.member.entity.Member;
import com.gdg.gdgbackend.domain.member.repository.MemberRepository;
import com.gdg.gdgbackend.domain.member.validator.MemberValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;
    private final MemberValidator memberValidator;

    @Transactional
    public void registerMember(Member member) {
        validateRegisterMember(member);
        memberRepository.save(member);
    }

    public void validateRegisterMember(Member member) {
        memberValidator.validateDuplicateMember(member.getLoginId());
    }

    public Optional<Member> findMemberByLoginId(String loginId) {
        return memberRepository.findByLoginId(loginId);
    }

}