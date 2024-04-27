package com.demo.dztourism.Acommodation.Controllers;

import com.demo.dztourism.Acommodation.Model.DTO.HotelDTO;
import com.demo.dztourism.Acommodation.Model.DTO.HotelGetDTO;

import com.demo.dztourism.Acommodation.Service.Impl.HotelServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/Hotel/")
@CrossOrigin("http://localhost:3000/")
public class HotelController {
    HotelServiceImpl hotelService ;


    @Autowired
    public HotelController(HotelServiceImpl hotelService) {
        this.hotelService = hotelService;
    }

    @PostMapping(value = "createHotel")
    public ResponseEntity<HotelDTO> createHotel(@RequestBody HotelDTO hotelDTO){

        HotelDTO savedHotel = hotelService.save(hotelDTO) ;
        return new ResponseEntity<>(savedHotel, HttpStatus.CREATED) ;


    }

    @GetMapping(value = "getAllHotels")
    public ResponseEntity<List<HotelGetDTO>> getAllHotels (){

        return new ResponseEntity<>(hotelService.getAllHotels(), HttpStatus.OK) ;


    }

    @GetMapping(value = "getHotelById/{Id}")
    public ResponseEntity<HotelGetDTO> getHotelById(@PathVariable Long Id){

        HotelGetDTO hotel = hotelService.getHotelById(Id);

        return new ResponseEntity<>(hotel, HttpStatus.OK);

    }

    @DeleteMapping(value = "deleteHotel/{id}")
    public ResponseEntity deleteHotel(@PathVariable Long id ){

        hotelService.deleteHotel(id);

        return new ResponseEntity( HttpStatus.NO_CONTENT) ;

    }

    @PutMapping(value = "update/{id}")
    public ResponseEntity<HotelDTO> updateHotel(@PathVariable Long id , @RequestBody HotelDTO hotelDTO){

        HotelDTO updatedHotel = hotelService.updateHotel(id , hotelDTO) ;
        if (updatedHotel!= null){
            return new ResponseEntity<>(updatedHotel , HttpStatus.OK) ;
        } else {
            return ResponseEntity.notFound().build() ;
        }


    }
}
