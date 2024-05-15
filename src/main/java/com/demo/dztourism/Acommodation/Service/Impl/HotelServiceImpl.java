package com.demo.dztourism.Acommodation.Service.Impl;

import com.demo.dztourism.Acommodation.Model.DTO.HotelDTO;
import com.demo.dztourism.Acommodation.Model.DTO.HotelGetDTO;
import com.demo.dztourism.Acommodation.Model.Hotel;
import com.demo.dztourism.Acommodation.Repository.HotelRepository;
import com.demo.dztourism.Acommodation.Service.HotelService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService {

   private final ModelMapper modelMapper ;
    private final HotelRepository hotelRepository ;

    @Override
    public HotelDTO save(HotelDTO hotelDTO) {

        Hotel hotel = modelMapper.map(hotelDTO , Hotel.class ) ;
        Hotel savedHotel = hotelRepository.save(hotel) ;
        return modelMapper.map(savedHotel , HotelDTO.class) ;
    }

    @Override
    public List<HotelGetDTO> getAllHotels() {

        List<Hotel> hotelList = hotelRepository.findAll();
        return hotelList.stream()
                .map(hotel -> modelMapper.map(hotel, HotelGetDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public HotelGetDTO getHotelById(Long Id) {

        Optional<Hotel> hotelOptional  = hotelRepository.findById(Id) ;

        if (hotelOptional.isPresent()) {
            Hotel hotel = hotelOptional.get();
            return modelMapper.map(hotel, HotelGetDTO.class);
        } else {
            return new HotelGetDTO() ;
        }

    }

    @Override
    public void deleteHotel(Long id) {
        hotelRepository.deleteById(id);
    }

    @Override
    public HotelDTO updateHotel(Long id , HotelDTO hotelDTO) {
       Optional<Hotel> hotel =  hotelRepository.findById(id) ;
       if (hotel.isPresent()){

           Hotel updatedhotel = modelMapper.map(hotelDTO , Hotel.class)  ;
           updatedhotel.setID_Hotel(id);
          return modelMapper.map( hotelRepository.save(updatedhotel), HotelDTO.class)  ;

       } else{

           return null ;

       }

    }


//    private Hotel HotelDTOToHotel(HotelDTO hotelDTO) {
//        return Hotel.builder()
//                .Name(hotelDTO.getName())
//                .Email(hotelDTO.getEmail())
//                .City(hotelDTO.getCity())
//                .Description(hotelDTO.getDescription())
//                .Country(hotelDTO.getCountry())
//                .Phone_number(hotelDTO.getPhone_number())
//                .Postal_Code(hotelDTO.getPostal_Code())
//                .Star_Rating(hotelDTO.getStar_Rating())
//                .Street_Address(hotelDTO.getStreet_Address())
//                .Latitude(hotelDTO.getLatitude())
//                .Longitude(hotelDTO.getLongitude())
//                .Timezone(hotelDTO.getTimezone())
//                .build() ;
//
//    }
//    private HotelDTO HotelToHotelDTO(Hotel hotel) {
//        return HotelDTO.builder()
//                .Name(hotel.getName())
//                .Email(hotel.getEmail())
//                .City(hotel.getCity())
//                .Description(hotel.getDescription())
//                .Country(hotel.getCountry())
//                .Phone_number(hotel.getPhone_number())
//                .Postal_Code(hotel.getPostal_Code())
//                .Star_Rating(hotel.getStar_Rating())
//                .Street_Address(hotel.getStreet_Address())
//                .Latitude(hotel.getLatitude())
//                .Longitude(hotel.getLongitude())
//                .Timezone(hotel.getTimezone())
//                .build() ;
//
//    }


}
