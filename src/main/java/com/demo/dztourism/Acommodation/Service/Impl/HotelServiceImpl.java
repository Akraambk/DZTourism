package com.demo.dztourism.Acommodation.Service.Impl;

import com.demo.dztourism.Acommodation.Model.DTO.HotelDTO;
import com.demo.dztourism.Acommodation.Model.Hotel;
import com.demo.dztourism.Acommodation.Repository.HotelRepository;
import com.demo.dztourism.Acommodation.Service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HotelServiceImpl implements HotelService {

    private final HotelRepository hotelRepository ;

    @Autowired
    public HotelServiceImpl(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @Override
    public HotelDTO save(HotelDTO hotelDTO) {

        Hotel hotel = HotelDTOToHotel(hotelDTO) ;
        Hotel savedHotel = hotelRepository.save(hotel) ;
        return HotelToHotelDTO(savedHotel) ;

    }

    private Hotel HotelDTOToHotel(HotelDTO hotelDTO) {
        return Hotel.builder()
                .Name(hotelDTO.getName())
                .Email(hotelDTO.getEmail())
                .City(hotelDTO.getCity())
                .Description(hotelDTO.getDescription())
                .Country(hotelDTO.getCountry())
                .Phone_number(hotelDTO.getPhone_number())
                .Postal_Code(hotelDTO.getPostal_Code())
                .Star_Rating(hotelDTO.getStar_Rating())
                .Street_Address(hotelDTO.getStreet_Address())
                .Latitude(hotelDTO.getLatitude())
                .Longitude(hotelDTO.getLongitude())
                .Timezone(hotelDTO.getTimezone())
                .build() ;

    }
    private HotelDTO HotelToHotelDTO(Hotel hotel) {
        return HotelDTO.builder()
                .Name(hotel.getName())
                .Email(hotel.getEmail())
                .City(hotel.getCity())
                .Description(hotel.getDescription())
                .Country(hotel.getCountry())
                .Phone_number(hotel.getPhone_number())
                .Postal_Code(hotel.getPostal_Code())
                .Star_Rating(hotel.getStar_Rating())
                .Street_Address(hotel.getStreet_Address())
                .Latitude(hotel.getLatitude())
                .Longitude(hotel.getLongitude())
                .Timezone(hotel.getTimezone())
                .build() ;

    }
}
