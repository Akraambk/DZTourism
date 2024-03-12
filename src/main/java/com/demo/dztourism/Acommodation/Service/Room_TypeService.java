package com.demo.dztourism.Acommodation.Service;

import com.demo.dztourism.Acommodation.Model.DTO.RoomDTO;
import com.demo.dztourism.Acommodation.Model.DTO.Room_typeDTO;

import java.util.List;

public interface Room_TypeService {

    Room_typeDTO createRoom_Type(Room_typeDTO room_typeDTO);

    List<Room_typeDTO> getAllRoom_Types () ;

    Room_typeDTO getRoom_TypeById(Long id) ;

    void deleteRoom_Type( Long id) ;

    Room_typeDTO updateRoom_Type(Long id , Room_typeDTO room_typeDTO) ;
}
