package com.gdg.gdgbackend.web.locationMeet.controller;

import com.gdg.gdgbackend.web.locationMeet.dto.LocationMeetDto;
import com.gdg.gdgbackend.web.locationMeet.service.LocationMeetService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class LocationMeetController {

    private final LocationMeetService locationMeetService;

    @GetMapping("/location-meet")
    public LocationMeetDto getLocationMeet(@RequestParam("main_category") String mainCategory,
                                           @AuthenticationPrincipal UserDetails userDetails) {

        LocationMeetDto locationMeetDto = locationMeetService.getLocationMeet(userDetails, mainCategory);

        return locationMeetDto;
    }
}