package com.demo.dztourism.Acommodation.Service;

import com.demo.dztourism.Acommodation.Model.DTO.HotelDTO;
import com.demo.dztourism.Acommodation.Model.DTO.HotelGetDTO;
import java.util.List;


public interface HotelService {

    HotelDTO save(HotelDTO hotel ) ;
    List<HotelGetDTO> getAllHotels () ;

    HotelGetDTO getHotelById(Long id) ;

    void deleteHotel( Long id) ;

    HotelDTO updateHotel(Long id , HotelDTO hotelDTO) ;
}
