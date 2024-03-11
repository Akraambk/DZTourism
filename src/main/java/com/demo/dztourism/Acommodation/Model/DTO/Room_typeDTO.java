package com.demo.dztourism.Acommodation.Model.DTO;

import com.demo.dztourism.Acommodation.Model.Amenity;
import com.demo.dztourism.Acommodation.Model.Room;
import jakarta.persistence.*;

import java.util.List;

public class Room_typeDTO {


    private String Name ;

    private String Description ;


    private List<Room> Room;


    private String Bed_Type ;

    private List<Amenity> Amenities ;
}
