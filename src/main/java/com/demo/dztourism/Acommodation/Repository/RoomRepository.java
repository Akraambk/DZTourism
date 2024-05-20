package com.demo.dztourism.Acommodation.Repository;

import com.demo.dztourism.Acommodation.Model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface  RoomRepository extends JpaRepository<Room, Long> {

    List<Room> findByHotelCityAndCapacity(String city , int capacity) ;
    @Query("SELECT CASE WHEN COUNT(r) > 0 THEN false ELSE true END " +
            "FROM Reservation res JOIN res.room r " +
            "WHERE r.roomId = :idRoom " +
            "AND ((res.Check_In <= :checkOut AND res.Check_Out >= :checkIn))")
    boolean isRoomAvailable(@Param("idRoom") Long idRoom, @Param("checkIn") Date checkIn, @Param("checkOut") Date checkOut);


    Optional<Room> findByRoomId(Long idRoom);
}
