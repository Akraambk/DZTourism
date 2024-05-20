package com.demo.dztourism.Acommodation.Booking;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Builder
public class BookingRequest {

    private Long room_id ;

    private Date Check_In ;

    private Date Check_Out ;

    private int Adults_Number ;

    private int Children_Number ;


}
