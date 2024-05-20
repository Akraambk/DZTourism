package com.demo.dztourism.Acommodation.Service.Impl;

import com.demo.dztourism.Acommodation.Model.DTO.RoomDTO;
import com.demo.dztourism.Acommodation.Model.Hotel;
import com.demo.dztourism.Acommodation.Model.Room;
import com.demo.dztourism.Acommodation.Repository.HotelRepository;
import com.demo.dztourism.Acommodation.Repository.RoomRepository;
import com.demo.dztourism.Acommodation.Service.RoomService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository ;
   private final  ModelMapper modelMapper ;
   private final  HotelRepository hotelRepository ;


    @Override
    public RoomDTO createRoom(RoomDTO roomDTO) {

        Optional<Hotel> hotel = hotelRepository.findById(roomDTO.getID_hotel()) ;


        if(hotel.isPresent()){

            Hotel OptionalHotel = hotel.get() ;
            Room room = modelMapper.map(roomDTO , Room.class) ;
            room.setHotel(OptionalHotel);
            return  modelMapper.map(roomRepository.save(room) , RoomDTO.class) ;

        } else {

            return null ;
        }


    }

    @Override
    public List<RoomDTO> getAllRooms() {
        return null;
    }

    @Override
    public RoomDTO getRoomById(Long id) {
        return null;
    }

    @Override
    public void deleteRoom(Long id) {

    }

    @Override
    public RoomDTO updateRoom(Long id, RoomDTO roomDTO) {
        return null;
    }


}
