package com.demo.dztourism.Acommodation.Service;

import com.demo.dztourism.Acommodation.Model.DTO.HotelDTO;
import com.demo.dztourism.Acommodation.Model.DTO.HotelGetDTO;
import com.demo.dztourism.Acommodation.Model.DTO.RoomDTO;
import com.demo.dztourism.Acommodation.Model.Room;

import java.util.List;

public interface RoomService {


    RoomDTO createRoom(RoomDTO roomDTO);

    List<RoomDTO> getAllRooms () ;

    RoomDTO getRoomById(Long id) ;

    void deleteRoom( Long id) ;

    RoomDTO updateRoom(Long id , RoomDTO roomDTO) ;


}
