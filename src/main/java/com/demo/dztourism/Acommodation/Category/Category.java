package com.demo.dztourism.Acommodation.Category;

import com.demo.dztourism.Acommodation.Activity.Activity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId ;

    private String name ;

    private String description;

    @OneToMany(
            mappedBy = "category" ,
            cascade = CascadeType.ALL
    )
    private List<Activity> activities ;




}
