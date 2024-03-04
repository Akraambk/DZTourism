package com.demo.dztourism.Acommodation.Controllers;

import com.demo.dztourism.Acommodation.Model.DTO.RoomDTO;
import com.demo.dztourism.Acommodation.Service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/Room/")
public class RoomController {

    RoomService roomService ;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @PostMapping(value = "createRoom")
    public ResponseEntity<RoomDTO> createRoom(@RequestBody RoomDTO roomDTO){


        RoomDTO savedRoom = roomService.save(roomDTO) ;
        return new ResponseEntity<>(savedRoom , HttpStatus.CREATED) ;

    }




}
