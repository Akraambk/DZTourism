package com.demo.dztourism.Acommodation.Activity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Builder
@Getter
@Setter
public class ActivityRequest {

    private String name;
    private String description;
    private Long categoryId;
    private String location;
    private LocalDate date;
    private int duration;
    private double price;
    private int capacity;
}
