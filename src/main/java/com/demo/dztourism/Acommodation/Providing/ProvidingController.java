package com.demo.dztourism.Acommodation.Providing;

import com.demo.dztourism.Acommodation.Activity.ActivityRequest;
import com.demo.dztourism.Acommodation.Activity.ActivityResponse;

import com.demo.dztourism.Acommodation.Category.CategoryRequest;
import com.demo.dztourism.Acommodation.Category.CategoryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Providing/")
public class ProvidingController {


    private final ProvideService provideService ;


    @PostMapping("ProvideActivity")

    public ResponseEntity<ActivityResponse> provideActivity(@RequestBody ActivityRequest request){


        return new ResponseEntity<>(provideService.ProvideActivity(request), HttpStatus.CREATED) ;

    }

    @PostMapping("ProvideCategory")
    public ResponseEntity<CategoryResponse> provideActivity(@RequestBody CategoryRequest request){


        return new ResponseEntity<>(provideService.ProvideCategory(request), HttpStatus.CREATED) ;

    }

}
