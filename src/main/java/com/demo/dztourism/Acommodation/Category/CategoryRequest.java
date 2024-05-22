package com.demo.dztourism.Acommodation.Category;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;



@Builder
@Getter
@Setter
public class CategoryRequest {

    private String name ;
    private String description;

}
