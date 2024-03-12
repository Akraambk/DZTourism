package com.demo.dztourism.Acommodation.Model.DTO;

import com.demo.dztourism.Acommodation.Model.Amenity;
import com.demo.dztourism.Acommodation.Model.Room;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Room_typeDTO {


    private String Name ;

    private String Description ;

    private List<Room> Room;

    private String Bed_Type ;

    private Long ID_Hotel ;

    private List<Amenity> Amenities ;
}
