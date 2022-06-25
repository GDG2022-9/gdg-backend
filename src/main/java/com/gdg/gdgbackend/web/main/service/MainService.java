package com.gdg.gdgbackend.web.main.service;

import com.gdg.gdgbackend.domain.board.entity.Board;
import com.gdg.gdgbackend.domain.board.repository.BoardRepository;
import com.gdg.gdgbackend.domain.member.entity.Member;
import com.gdg.gdgbackend.domain.member.repository.MemberRepository;
import com.gdg.gdgbackend.global.error.exception.EntityNotFoundException;
import com.gdg.gdgbackend.global.error.exception.ErrorCode;
import com.gdg.gdgbackend.web.main.dto.MainDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MainService {

    private final MemberRepository memberRepository;

    private final BoardRepository boardRepository;

    public MainDto getMain(String loginId) {

        // 나의 여행 일정
        Member member = memberRepository.findByLoginId(loginId)
                .orElseThrow(() -> new EntityNotFoundException(ErrorCode.MEMBER_NOT_EXIST));

        LocalDateTime tripStartDate = member.getTripStartDate();
        Integer tripDuration = member.getTripDuration();
        LocalDateTime tripEndDate = tripStartDate.plusDays(tripDuration);

        // 맞춤 밋트 & 실시간 밋트
        List<Board> customBoardList = boardRepository.findAllByBoardDateBetween(tripStartDate, tripEndDate);
        List<Board> currentBoardList = boardRepository.findAllByOrdOrderByBoardDateAsc();

        List<Board> customMeet = new ArrayList<>();
        List<Board> currentMeet = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            customMeet.add(customBoardList.get(i));
            currentMeet.add(customBoardList.get(i));
        }

        MainDto mainDto = MainDto.of(tripStartDate, tripDuration, customMeet, currentMeet);

        return mainDto;

    }
}
