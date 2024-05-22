package com.demo.dztourism.Activity;

import com.demo.dztourism.Acommodation.User.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ActivityService {

    private final ActivityRepository activityRepository ;

    public ActivityResponse ProvideActivity( ActivityRequest request){

        var user = ((User) SecurityContextHolder
                .getContext().getAuthentication().getPrincipal());
        Activity newActivity = Activity.builder()
                .name(request.getName())
                .category(request.getCategory())
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

}
