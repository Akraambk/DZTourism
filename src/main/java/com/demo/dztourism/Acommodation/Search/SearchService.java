package com.demo.dztourism.Acommodation.Search;

import com.demo.dztourism.Acommodation.Model.Room;
import com.demo.dztourism.Acommodation.Repository.RoomRepository;
import com.demo.dztourism.Acommodation.Service.Impl.RoomServiceImpl;
import com.demo.dztourism.Acommodation.Service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchService {

    private final RoomRepository roomRepository ;

    public SearchResponse Search(SearchRequest request){

      List<Room> rooms =   roomRepository.findByHotelCityAndCapacity(request.getDestination() , request.getAdultsNumber()) ;

      rooms.forEach( room -> {
                  isAvailable(room, request.getCheckIn(), request.getCheckOut());
              }
      );


      return SearchResponse.builder()
              .Rooms(rooms)
              .build() ;
    }

    public void isAvailable(Room room , Date checkIn , Date checkOut) {

        if (roomRepository.isRoomAvailable(room.getRoomId(), checkIn, checkOut)){
            room.setAvailability_status(true);
        }else {
            room.setAvailability_status(false);
        }
    }


}
