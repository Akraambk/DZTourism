package com.demo.dztourism.Acommodation.Model.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    private String Description ;

    private String City ;

    private String Country ;

}
