package com.gdg.gdgbackend.web.locationMeet.controller;

import com.gdg.gdgbackend.web.locationMeet.dto.LocationMeetDto;
import com.gdg.gdgbackend.web.locationMeet.service.LocationMeetService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class LocationMeetController {

    private final LocationMeetService locationMeetService;

    @ApiOperation(value = "지역별 밋트 정보 가져오기")
    @GetMapping("/location-meet")
    public LocationMeetDto getLocationMeet(@RequestParam("main_category") String mainCategory,
                                           @RequestParam("startDate") String startDate,
                                           @RequestParam("endDate") String endDate) {

        LocationMeetDto locationMeetDto = locationMeetService.getLocationMeet(mainCategory, startDate, endDate);

        return locationMeetDto;
    }
}