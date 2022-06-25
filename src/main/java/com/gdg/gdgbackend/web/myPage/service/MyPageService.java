package com.gdg.gdgbackend.web.myPage.service;

import com.gdg.gdgbackend.domain.member.entity.Member;
import com.gdg.gdgbackend.domain.member.repository.MemberRepository;
import com.gdg.gdgbackend.global.error.exception.EntityNotFoundException;
import com.gdg.gdgbackend.global.error.exception.ErrorCode;
import com.gdg.gdgbackend.web.myPage.dto.MyPageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MyPageService {

    private final MemberRepository memberRepository;
    public MyPageDto getMyPage(UserDetails userDetails) {
        String loginId = userDetails.getUsername();
        Member member = memberRepository.findByLoginId(loginId)
                .orElseThrow(() -> new EntityNotFoundException(ErrorCode.MEMBER_NOT_EXIST));

        MyPageDto myPageDto = MyPageDto.builder()
                .userName(member.getMemberName())
                .startDate(member.getTripStartDate())
                .duration(member.getTripDuration())
                .build();

        return myPageDto;
    }

    @Transactional
    public void registerTrip(UserDetails userDetails, MyPageDto myPageDto) {
        String loginId = userDetails.getUsername();
        Member member = memberRepository.findByLoginId(loginId)
                .orElseThrow(() -> new EntityNotFoundException(ErrorCode.MEMBER_NOT_EXIST));
        member.updateItem(myPageDto.getStartDate(), myPageDto.getDuration());
    }
}
