package com.demo.dztourism.Acommodation.Booking;

import com.demo.dztourism.Acommodation.Model.Reservation;
import com.demo.dztourism.Acommodation.Model.Room;
import com.demo.dztourism.Acommodation.Repository.RoomRepository;
import com.demo.dztourism.Acommodation.User.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final RoomRepository roomRepository ;
    private final ReservationRepository reservationRepository ;


    public BookingResponse bookRoom(BookingRequest request){

        boolean available = roomRepository.isRoomAvailable(request.getRoom_id(), request.getCheck_In(), request.getCheck_Out());

        if (!available) {
            return BookingResponse
                    .builder()
                    .success(false)
                    .message("Room is not available for the given dates")
                    .build();
        }

        Optional<Room> optionalRoom = roomRepository.findByRoomId(request.getRoom_id());
        if (optionalRoom.isEmpty()) {
            return  BookingResponse.builder()
                    .success(false)
                    .message("Room not found")
                    .build();
        }


        var user = ((User)SecurityContextHolder.getContext().getAuthentication().getPrincipal()) ;

        Room bookedRoom = optionalRoom.get();
             reservationRepository.save(
                    Reservation.builder()
                            .room(bookedRoom)
                            .Check_In(request.getCheck_In())
                            .Check_Out(request.getCheck_Out())
                            .Adults_Number(request.getAdults_Number())
                            .Children_Number(request.getChildren_Number())
                            .Reservation_status(true)
                            .client(user)
                            .build()
            ) ;


             return BookingResponse.builder()
                     .success(true)
                     .message("Room Booked successfully")
                     .build();





    }



}
