package com.demo.dztourism.Acommodation.Service.Impl;

import com.demo.dztourism.Acommodation.Model.DTO.HotelGetDTO;
import com.demo.dztourism.Acommodation.Model.DTO.Room_typeDTO;
import com.demo.dztourism.Acommodation.Model.Hotel;
import com.demo.dztourism.Acommodation.Model.Room_Type;
import com.demo.dztourism.Acommodation.Repository.HotelRepository;
import com.demo.dztourism.Acommodation.Repository.RoomRepository;
import com.demo.dztourism.Acommodation.Repository.Room_TypeRepository;
import com.demo.dztourism.Acommodation.Service.Room_TypeService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class Room_TypeServiceImpl implements Room_TypeService {

    private final Room_TypeRepository roomTypeRepository ;
    private final ModelMapper modelMapper ;
    private final RoomRepository roomRepository ;

    private final HotelServiceImpl hotelService ;

    public Room_TypeServiceImpl(Room_TypeRepository roomTypeRepository, ModelMapper modelMapper, RoomRepository roomRepository, HotelServiceImpl hotelService) {
        this.roomTypeRepository = roomTypeRepository;
        this.modelMapper = modelMapper;
        this.roomRepository = roomRepository;
        this.hotelService = hotelService;

    }

    @Override
    public Room_typeDTO createRoom_Type(Room_typeDTO room_typeDTO) {

        Room_Type roomType = modelMapper.map(room_typeDTO , Room_Type.class ) ;
        Room_Type savedRoomType = roomTypeRepository.save(roomType) ;

        HotelGetDTO hotelDTO = hotelService.getHotelById(room_typeDTO.getID_Hotel()) ;
        Hotel  hotel=  modelMapper.map(hotelDTO , Hotel.class ) ;

        savedRoomType.getRoom()
                .forEach( room -> room.setHotel(hotel) );
        savedRoomType.getRoom()
                .forEach( room -> room.setRoom_Type(savedRoomType) );

        roomRepository.saveAll(savedRoomType.getRoom()) ;
        return modelMapper.map( roomTypeRepository.save(roomType) , Room_typeDTO.class );
    }



    @Override
    public List<Room_typeDTO> getAllRoom_Types() {
        return null;
    }

    @Override
    public Room_typeDTO getRoom_TypeById(Long id) {
        return null;
    }

    @Override
    public void deleteRoom_Type(Long id) {

    }

    @Override
    public Room_typeDTO updateRoom_Type(Long id, Room_typeDTO room_typeDTO) {
        return null;
    }
}
