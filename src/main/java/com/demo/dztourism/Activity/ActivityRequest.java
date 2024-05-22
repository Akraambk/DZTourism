package com.demo.dztourism.Activity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
public class ActivityRequest {

    private String name;
    private String description;
    private String category;
    private String location;
    private LocalDateTime date;
    private int duration;
    private double price;
    private int capacity;
}
