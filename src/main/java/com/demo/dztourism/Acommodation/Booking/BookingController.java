package com.demo.dztourism.Acommodation.Booking;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Booking/")
public class BookingController {

    private final BookingService bookingService ;

    @PostMapping("roomBooking")
    public ResponseEntity<BookingResponse> book(@RequestBody BookingRequest request){

       return new ResponseEntity<>(bookingService.bookRoom(request), HttpStatus.CREATED)  ;

    }

}
