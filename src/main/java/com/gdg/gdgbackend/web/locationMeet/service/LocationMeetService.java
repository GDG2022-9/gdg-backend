package com.gdg.gdgbackend.web.locationMeet.service;

import com.gdg.gdgbackend.domain.board.entity.Board;
import com.gdg.gdgbackend.domain.board.repository.BoardRepository;
import com.gdg.gdgbackend.domain.category.entity.Category;
import com.gdg.gdgbackend.domain.category.repository.CategoryRepository;
import com.gdg.gdgbackend.domain.member.entity.Member;
import com.gdg.gdgbackend.domain.member.repository.MemberRepository;
import com.gdg.gdgbackend.global.error.exception.EntityNotFoundException;
import com.gdg.gdgbackend.global.error.exception.ErrorCode;
import com.gdg.gdgbackend.web.locationMeet.dto.LocationMeetDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class LocationMeetService {

    private final CategoryRepository categoryRepository;

    private final MemberRepository memberRepository;

    private final BoardRepository boardRepository;

    public LocationMeetDto getLocationMeet(UserDetails userDetails, String mainCategory) {

        // 소분류
        List<Category> categoryList = categoryRepository.findAllByCategoryMain(mainCategory);
        List<String> subCategoryList = new ArrayList<>();

        for (int i = 0; i < categoryList.size(); i++) {
            subCategoryList.add(categoryList.get(i).getCategorySub());
        }

        // 밋트 개수
        String loginId = userDetails.getUsername();
        Member member = memberRepository.findByLoginId(loginId)
                .orElseThrow(() -> new EntityNotFoundException(ErrorCode.MEMBER_NOT_EXIST));
        LocalDateTime startDate = member.getTripStartDate();
        Integer tripDuration = member.getTripDuration();
        LocalDateTime endDate = startDate.plusDays(tripDuration);
        long meetCount = boardRepository.getCount(startDate, endDate);
        int count = Long.valueOf(meetCount).intValue();

        // 밋트 리스트
        List<Board> locationMeetList = boardRepository.findAllByBoardDateBetween(startDate, endDate);

        return LocationMeetDto.builder()
                .subCategoryList(subCategoryList)
                .count(count)
                .locationMeetList(locationMeetList)
                .build();
    }
}
