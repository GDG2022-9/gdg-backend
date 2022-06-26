package com.gdg.gdgbackend.api.locationMeet.service;

import com.gdg.gdgbackend.domain.board.entity.Board;
import com.gdg.gdgbackend.domain.board.repository.BoardRepository;
import com.gdg.gdgbackend.domain.category.entity.Category;
import com.gdg.gdgbackend.domain.category.repository.CategoryRepository;
import com.gdg.gdgbackend.api.locationMeet.dto.LocationMeetDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class LocationMeetService {

    private final CategoryRepository categoryRepository;

    private final BoardRepository boardRepository;

    public LocationMeetDto getLocationMeet(String mainCategory, String startDate, String endDate) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        LocalDateTime start = LocalDateTime.parse(startDate, formatter);
        LocalDateTime end = LocalDateTime.parse(endDate, formatter);

        // 소분류
        List<Category> categoryList = categoryRepository.findAllByCategoryMain(mainCategory);
        List<String> subCategoryList = new ArrayList<>();

        for (int i = 0; i < categoryList.size(); i++) {
            subCategoryList.add(categoryList.get(i).getCategorySub());
        }

        // 밋트 개수
        long meetCount = boardRepository.getCount(start, end);
        int count = Long.valueOf(meetCount).intValue();

        // 밋트 리스트
        List<Board> locationMeetList = boardRepository.findAllByBoardDateBetween(start, end);

        return LocationMeetDto.builder()
                .subCategoryList(subCategoryList)
                .count(count)
                .locationMeetList(locationMeetList)
                .build();
    }
}
