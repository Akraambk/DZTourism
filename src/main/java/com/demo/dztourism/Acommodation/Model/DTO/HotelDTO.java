package com.demo.dztourism.Acommodation.Model.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HotelDTO {

    private String Name ;

    private int Phone_number ;

    private String Email ;

    private int Star_Rating ;

    private String Description ;

    private String Street_Address ;

    private String City ;

    private int Postal_Code ;

    private String Country ;

    private int Latitude ;

    private int Longitude ;

    private String Timezone ;
}
