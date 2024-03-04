package com.demo.dztourism.Acommodation.Model.DTO;

import com.demo.dztourism.Acommodation.Model.Hotel;
import com.demo.dztourism.Acommodation.Model.Room_Type;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoomDTO {


    private int Capacity ;

    private String Description ;

    private Boolean availability_status ;

    private Long ID_hotel ;

    private Long ID_Room_Type ;
}
