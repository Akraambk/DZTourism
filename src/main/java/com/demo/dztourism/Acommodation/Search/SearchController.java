package com.demo.dztourism.Acommodation.Search;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping( "/Search/")
@RequiredArgsConstructor
public class SearchController {

    private final SearchService searchService ;

    @GetMapping("search")
    public ResponseEntity<SearchResponse> search(@RequestBody @Valid SearchRequest request){

        return ResponseEntity.ok(searchService.Search(request)) ;

    }
}
