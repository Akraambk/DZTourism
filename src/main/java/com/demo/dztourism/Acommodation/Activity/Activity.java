package com.demo.dztourism.Acommodation.Activity;

import com.demo.dztourism.Acommodation.Category.Category;
import com.demo.dztourism.Acommodation.User.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;




@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Activity_ID;
    private String name;
    private String description;

    private String location;
    private LocalDate date;
    private int duration;
    private double price;
    private int capacity;


    @ManyToOne
    @JoinColumn(
            name = "ID"
    )
    @JsonIgnore
    private User Provider;

    @ManyToOne
    @JoinColumn(
           name = "category_id"
    )
    @JsonIgnore
    private Category category;







}

