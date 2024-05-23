package com.demo.dztourism.Acommodation.Controllers;

import com.demo.dztourism.Acommodation.Model.DTO.Room_typeDTO;
import com.demo.dztourism.Acommodation.Model.Room_Type;
import com.demo.dztourism.Acommodation.Service.Impl.Room_TypeServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/RoomType/")
@CrossOrigin(origins = "http://localhost:3000")
public class Room_TypeController {

   private final Room_TypeServiceImpl roomTypeService ;
    public Room_TypeController(Room_TypeServiceImpl roomTypeService) {
        this.roomTypeService = roomTypeService;
    }

    @PostMapping(value = "CreateRoomType")

    public ResponseEntity<Room_typeDTO> CreateRoomType(@RequestBody Room_typeDTO room_typeDTO ){



        return new ResponseEntity<>(roomTypeService.createRoom_Type(room_typeDTO ) , HttpStatus.CREATED) ;

    }

    @GetMapping("SearchRoomTypeByHotel")
    public ResponseEntity<List<Room_Type>> SearchRoomTypeByHotel(@RequestParam Long hotelId){

        return new ResponseEntity<>(roomTypeService.SearchRoomTypeByHotel(hotelId) ,HttpStatus.FOUND) ;

    }
}
