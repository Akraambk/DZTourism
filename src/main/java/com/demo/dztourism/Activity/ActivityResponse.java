package com.demo.dztourism.Activity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
public class ActivityResponse {

    private boolean success;
    private String message;



}
