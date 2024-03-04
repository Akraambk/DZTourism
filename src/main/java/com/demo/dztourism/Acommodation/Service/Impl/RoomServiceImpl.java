package com.demo.dztourism.Acommodation.Service.Impl;

import com.demo.dztourism.Acommodation.Model.DTO.RoomDTO;
import com.demo.dztourism.Acommodation.Model.Hotel;
import com.demo.dztourism.Acommodation.Model.Room;
import com.demo.dztourism.Acommodation.Repository.HotelRepository;
import com.demo.dztourism.Acommodation.Repository.RoomRepository;
import com.demo.dztourism.Acommodation.Service.RoomService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomServiceImpl implements RoomService {

    RoomRepository roomRepository ;
    ModelMapper modelMapper ;

    HotelRepository hotelRepository ;

    @Autowired
    public RoomServiceImpl(RoomRepository roomRepository , ModelMapper modelMapper , HotelRepository hotelRepository) {
        this.roomRepository = roomRepository;
        this.modelMapper = modelMapper ;
        this.hotelRepository = hotelRepository ;
    }

    @Override
    public RoomDTO save(RoomDTO roomDTO) {
        return null;
    }

    @Override
    public RoomDTO createRoom(RoomDTO roomDTO) {

        Optional<Hotel> hotel = hotelRepository.findById(roomDTO.getID_hotel()) ;


        Room room = modelMapper.map(roomDTO , Room.class) ;

        return  modelMapper.map(roomRepository.save(room) , RoomDTO.class)  ;

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
