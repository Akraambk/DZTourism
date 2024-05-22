package com.demo.dztourism.Acommodation.Activity;

import com.demo.dztourism.Acommodation.Category.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.time.LocalDate;
import java.util.List;

@Repository
public interface ActivityRepository extends JpaRepository<Activity , Long> {
    List<Activity> findByLocationAndCategoryAndDate(String location, Category category , LocalDate date) ;
}
