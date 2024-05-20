package com.demo.dztourism.Acommodation.Booking;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Builder
@Getter
@Setter
public class BookingResponse {

    private boolean success;
    private String message;
}
