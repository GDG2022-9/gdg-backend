package com.gdg.gdgbackend.domain.member.validator;

import com.gdg.gdgbackend.domain.member.entity.Member;
import com.gdg.gdgbackend.domain.member.repository.MemberRepository;
import com.gdg.gdgbackend.global.error.exception.BusinessException;
import com.gdg.gdgbackend.global.error.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberValidator {

    private final MemberRepository memberRepository;

    public void validateDuplicateMember(String logIn) {
        Optional<Member> optionalMember = memberRepository.findByLoginId(logIn);
        if (optionalMember.isPresent()) {
            throw new BusinessException(ErrorCode.ALREADY_REGISTERED_MEMBER);
        }
    }

}