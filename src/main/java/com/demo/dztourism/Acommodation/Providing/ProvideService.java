package com.demo.dztourism.Acommodation.Providing;

import com.demo.dztourism.Acommodation.Activity.Activity;
import com.demo.dztourism.Acommodation.Activity.ActivityRepository;
import com.demo.dztourism.Acommodation.Activity.ActivityRequest;
import com.demo.dztourism.Acommodation.Activity.ActivityResponse;

import com.demo.dztourism.Acommodation.Category.Category;
import com.demo.dztourism.Acommodation.Category.CategoryRepository;
import com.demo.dztourism.Acommodation.Category.CategoryRequest;
import com.demo.dztourism.Acommodation.Category.CategoryResponse;
import com.demo.dztourism.Acommodation.User.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProvideService {

    final private ActivityRepository activityRepository ;
    final private CategoryRepository categoryRepository ;

    public ActivityResponse ProvideActivity(ActivityRequest request){

        var user = ((User) SecurityContextHolder
                .getContext().getAuthentication().getPrincipal());

        Optional<Category> categoryOptional = categoryRepository.findById(request.getCategoryId());

        if (categoryOptional.isEmpty()) {

            return ActivityResponse.builder()
                    .success(false)
                    .message("Category not found")
                    .build();
        }

        Category category = categoryOptional.get();
        Activity newActivity = Activity.builder()
                .name(request.getName())
                .category(category)
                .date(request.getDate())
                .price(request.getPrice())
                .duration(request.getDuration())
                .location(request.getLocation())
                .capacity(request.getCapacity())
                .description(request.getDescription())
                .Provider(user)
                .build() ;
        activityRepository.save(newActivity) ;

        return ActivityResponse.builder()
                .success(true)
                .message("the Activity is successfully added ")
                .build();

    }

    public CategoryResponse ProvideCategory(CategoryRequest request){

     Category newCategory =  Category.builder()
                .name(request.getName())
                .description(request.getDescription())
                .build() ;

     categoryRepository.save(newCategory) ;
        return CategoryResponse.builder()
                .success(true)
                .message("the Category is successfully added ")
                .build();
    }





}

