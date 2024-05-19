package com.demo.dztourism.Acommodation.Repository;

import com.demo.dztourism.Acommodation.Model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface  RoomRepository extends JpaRepository<Room, Long> {

    List<Room> findByHotelCityAndCapacity(String city , int capacity) ;


}
