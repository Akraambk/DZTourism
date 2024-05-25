package com.demo.dztourism.Acommodation.Booking;

import com.demo.dztourism.Acommodation.Model.Reservation;
import com.demo.dztourism.Acommodation.Model.Room;
import com.demo.dztourism.Acommodation.Repository.RoomRepository;
import com.demo.dztourism.Acommodation.Search.SearchService;
import com.demo.dztourism.Acommodation.User.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final RoomRepository roomRepository ;
    private final ReservationRepository reservationRepository ;

    private final SearchService searchService ;

//    public BookingResponse bookRoom(BookingRequest request){
//        Optional<Room> optionalRoom = roomRepository.findById(request.getRoom_id());
//        if (optionalRoom.isEmpty()) {
//            return  BookingResponse.builder()
//                    .success(false)
//                    .message("Room not found")
//                    .build();
//        } Room bookedRoom = optionalRoom.get();
//        searchService.isAvailable(bookedRoom , request.getCheck_In() , request.getCheck_Out());
//    //    boolean available = roomRepository.isRoomAvailable(request.getRoom_id(), request.getCheck_In(), request.getCheck_Out());
//
//        if (bookedRoom.getAvailability_status() == false) {
//            return BookingResponse
//                    .builder()
//                    .success(false)
//                    .message("Room is not available for the given dates")
//                    .build();
//        }
//
//        var user = ((User)SecurityContextHolder.getContext().getAuthentication().getPrincipal()) ;
//
//
//             reservationRepository.save(
//                    Reservation.builder()
//                            .room(bookedRoom)
//                            .Check_In(request.getCheck_In())
//                            .Check_Out(request.getCheck_Out())
//                            .Adults_Number(request.getAdults_Number())
//                            .Children_Number(request.getChildren_Number())
//                            .Reservation_status(true)
//                            .client(user)
//                            .build()
//            ) ;
//
//
//             return BookingResponse.builder()
//                     .success(true)
//                     .message("Room Booked successfully")
//                     .build();
//
//
//
//
//
//    }

//    public BookingResponse BookListRooms(BookingRequest request){
//
//        for (Long roomId : request.getRoom_id()){
//
//            Optional<Room> optionalRoom = roomRepository.findById(roomId);
//            if (optionalRoom.isEmpty()) {
//                return  BookingResponse.builder()
//                        .success(false)
//                        .message("Room not found")
//                        .build();
//            }
//            Room bookedRoom = optionalRoom.get();
//            searchService.isAvailable(bookedRoom , request.getCheck_In() , request.getCheck_Out());
//
//            if (bookedRoom.getAvailability_status() == false) {
//                return BookingResponse
//                        .builder()
//                        .success(false)
//                        .message("Room is not available for the given dates")
//                        .build();
//            }
//
//        }
//
//        for ()
//        List<Room> bookedRooms =
//
//
//        var user = ((User)SecurityContextHolder.getContext().getAuthentication().getPrincipal()) ;
//
//
//        reservationRepository.save(
//                Reservation.builder()
//                        .room(bookedRoom)
//                        .Check_In(request.getCheck_In())
//                        .Check_Out(request.getCheck_Out())
//                        .Adults_Number(request.getAdults_Number())
//                        .Children_Number(request.getChildren_Number())
//                        .Reservation_status(true)
//                        .client(user)
//                        .build()
//        ) ;
//
//
//        return BookingResponse.builder()
//                .success(true)
//                .message("Room Booked successfully")
//                .build();
//
//
//
//
//    }
//
//

    public BookingResponse bookListRoom(BookingRequest request) {
        List<Room> bookedRooms = new ArrayList<>();
        var user = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());

        // Check the availability of all requested rooms first
        for (Long roomId : request.getRoom_id()) {
            boolean available = roomRepository.isRoomAvailable(roomId, request.getCheck_In(), request.getCheck_Out());
            if (!available) {
                return BookingResponse
                        .builder()
                        .success(false)
                        .message("Room " + roomId + " is not available for the given dates")
                        .build();
            }
        }

        // If all rooms are available, proceed to book them
        for (Long roomId : request.getRoom_id()) {
            Optional<Room> optionalRoom = roomRepository.findById(roomId);
            if (optionalRoom.isEmpty()) {
                return BookingResponse
                        .builder()
                        .success(false)
                        .message("Room " + roomId + " not found")
                        .build();
            }

            bookedRooms.add(optionalRoom.get());
        }

        // Save the reservation after ensuring all rooms are available
        Reservation reservation = Reservation.builder()
                .rooms(bookedRooms)
                .Check_In(request.getCheck_In())
                .Check_Out(request.getCheck_Out())
                .Adults_Number(request.getAdults_Number())
                .Children_Number(request.getChildren_Number())
                .Reservation_status(true)
                .client(user)
                .build();

        reservationRepository.save(reservation);

        return BookingResponse.builder()
                .success(true)
                .message("Room(s) booked successfully")
                .build();
    }



}
