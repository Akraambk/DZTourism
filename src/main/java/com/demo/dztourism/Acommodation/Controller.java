package com.demo.dztourism.Acommodation;

import com.demo.dztourism.Acommodation.Model.DTO.HotelDTO;
import com.demo.dztourism.Acommodation.Service.Impl.HotelServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    HotelServiceImpl hotelService ;


    @Autowired
    public Controller(HotelServiceImpl hotelService) {
        this.hotelService = hotelService;
    }

    @PostMapping(value = "/Acommodation/createHotel")
    public ResponseEntity<HotelDTO> createBook(@RequestBody HotelDTO hotelDTO){

        HotelDTO savedHotel = hotelService.save(hotelDTO) ;
        return new ResponseEntity<HotelDTO>(savedHotel , HttpStatus.CREATED) ;


    }
}
