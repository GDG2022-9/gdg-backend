package com.gdg.gdgbackend.web.customMeet.controller;


import com.gdg.gdgbackend.web.customMeet.dto.CustomMeetDto;
import com.gdg.gdgbackend.web.customMeet.service.CustomMeetService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CustomMeetController {

    private final CustomMeetService customMeetService;

    @ApiOperation(value = "맞춤 밋트 정보 가져오기")
    @GetMapping("/custom")
    public ResponseEntity getCustomMeet(@RequestParam("startDate") String startDate,
                                        @RequestParam("endDate") String endDate) {

        CustomMeetDto customMeetDto = customMeetService.getCustomMeet(startDate, endDate);

        return ResponseEntity.ok(customMeetDto);
    }
}
