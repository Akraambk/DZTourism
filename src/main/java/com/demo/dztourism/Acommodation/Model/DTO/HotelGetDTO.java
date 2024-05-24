package com.demo.dztourism.Acommodation.Model.DTO;

import com.demo.dztourism.Acommodation.Model.Room;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HotelGetDTO {

    private Long ID_Hotel ;

    private String Name ;

    private int Phone_number ;

    private String Email ;

    private int Star_Rating ;

    private String Street_Address ;

    private String Description ;

    private int Postal_Code ;

    private String City ;

    private String Country ;

    private List<Room> Room;

    private int Latitude ;

    private int Longitude ;

    private String Timezone ;

}
