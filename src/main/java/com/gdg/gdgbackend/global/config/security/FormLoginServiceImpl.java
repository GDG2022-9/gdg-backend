package com.gdg.gdgbackend.global.config.security;

import com.gdg.gdgbackend.domain.member.entity.Member;
import com.gdg.gdgbackend.domain.member.service.MemberService;
import com.gdg.gdgbackend.global.error.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FormLoginServiceImpl implements UserDetailsService {

    private final MemberService memberService;

    @Override
    public UserDetails loadUserByUsername(String loginId) throws UsernameNotFoundException {

        Member member = memberService.findMemberByLoginId(loginId)
                .orElseThrow(() -> new UsernameNotFoundException(ErrorCode.LOGIN_ERROR.getMessage()));

        return new UserDetailsImpl(member);
    }

}