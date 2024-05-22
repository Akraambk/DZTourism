package com.demo.dztourism.Acommodation.Search;

import com.demo.dztourism.Acommodation.Activity.Activity;
import com.demo.dztourism.Acommodation.Activity.ActivityRequest;
import com.demo.dztourism.Acommodation.Category.Category;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "/Search/")
@RequiredArgsConstructor
public class SearchController {

    private final SearchService searchService ;

    @GetMapping("/Room")
    public ResponseEntity<SearchResponse> searchForRoom(@RequestBody @Valid SearchRequest request){

        return ResponseEntity.ok(searchService.SearchForRoom(request)) ;

    }

    @GetMapping("SearchActivity")
    public ResponseEntity<List<Activity>> SearchActivity(@RequestBody ActivityRequest request){

        return new ResponseEntity<>( searchService.SearchForActivity(request), HttpStatus.OK )   ;

    }

    @GetMapping("GetAllCategories")
    public ResponseEntity<List<Category>> GetAllCategories (){
        return new ResponseEntity<>( searchService.GetAllCategories() , HttpStatus.OK) ;
    }


}
