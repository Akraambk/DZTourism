package com.demo.dztourism.Acommodation.Search;

import com.demo.dztourism.Acommodation.Model.Room;
import com.demo.dztourism.Acommodation.Model.Room_Type;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SearchHotelResponse {


    private String Name ;

    private String Phone_number ;

    private String Email ;

    private int Star_Rating ;

    private String Description ;

    private String Street_Address ;

    private String city ;

    private int Postal_Code ;

    private String Country ;

    private int Latitude ;

    private int Longitude ;

    private String Timezone ;

    private String Photos ;

    private List<Room_Type> room_type ;

}
