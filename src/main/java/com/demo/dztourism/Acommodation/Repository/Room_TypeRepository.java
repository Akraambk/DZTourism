package com.demo.dztourism.Acommodation.Repository;

import com.demo.dztourism.Acommodation.Model.Hotel;
import com.demo.dztourism.Acommodation.Model.Room_Type;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Room_TypeRepository extends JpaRepository<Room_Type , Long > {

    List<Room_Type> findByHotel(Hotel hotel );
}
