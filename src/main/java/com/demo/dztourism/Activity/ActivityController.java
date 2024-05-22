package com.demo.dztourism.Activity;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Activity/")
public class ActivityController {

    private final ActivityService activityService ;


    @PostMapping("ProvideActivity")

    public ResponseEntity<ActivityResponse> provideActivity(@RequestBody ActivityRequest request){


       return new ResponseEntity<>(activityService.ProvideActivity(request) , HttpStatus.CREATED) ;

    }


}
