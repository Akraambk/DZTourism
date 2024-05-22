package com.demo.dztourism.Activity;

import com.demo.dztourism.Acommodation.User.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String category;
    private String location;
    private LocalDateTime date;
    private int duration;
    private double price;
    private int capacity;


    @ManyToOne
    private User Provider;








}

