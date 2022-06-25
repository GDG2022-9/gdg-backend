package com.gdg.gdgbackend.web.main.controller;

import com.gdg.gdgbackend.web.main.dto.MainDto;
import com.gdg.gdgbackend.web.main.service.MainService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MainController {

    private final MainService mainService;

    @ApiOperation(value = "메인페이지")
    @GetMapping("/main")
    public ResponseEntity getMain(@RequestParam("startDate") String startDate,
                                  @RequestParam("endDate") String endDate) {

        MainDto mainDto = mainService.getMain(startDate, endDate);

        return ResponseEntity.ok(mainDto);
    }

}
