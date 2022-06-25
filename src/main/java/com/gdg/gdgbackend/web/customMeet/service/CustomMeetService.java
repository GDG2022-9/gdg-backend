package com.gdg.gdgbackend.web.customMeet.service;

import com.gdg.gdgbackend.domain.board.entity.Board;
import com.gdg.gdgbackend.domain.board.repository.BoardRepository;
import com.gdg.gdgbackend.domain.member.entity.Member;
import com.gdg.gdgbackend.domain.member.repository.MemberRepository;
import com.gdg.gdgbackend.global.error.exception.EntityNotFoundException;
import com.gdg.gdgbackend.global.error.exception.ErrorCode;
import com.gdg.gdgbackend.web.customMeet.dto.CustomMeetDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CustomMeetService {

    private final MemberRepository memberRepository;

    private final BoardRepository boardRepository;
    public CustomMeetDto getCustomMeet(String loginId) {

        Member member = memberRepository.findByLoginId(loginId)
                .orElseThrow(() -> new EntityNotFoundException(ErrorCode.MEMBER_NOT_EXIST));

        LocalDateTime tripStartDate = member.getTripStartDate();
        Integer tripDuration = member.getTripDuration();
        LocalDateTime tripEndDate = tripStartDate.plusDays(tripDuration);

        List<Board> customMeetList = boardRepository.findAllByBoardDateBetween(tripStartDate, tripEndDate);

        CustomMeetDto customMeetDto = CustomMeetDto.builder()
                .tripStartDate(tripStartDate)
                .tripDuration(tripDuration)
                .customMeetList(customMeetList)
                .build();

        return customMeetDto;
    }
}
