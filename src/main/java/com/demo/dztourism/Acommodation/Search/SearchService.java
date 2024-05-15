package com.demo.dztourism.Acommodation.Search;

import com.demo.dztourism.Acommodation.Model.Room;
import com.demo.dztourism.Acommodation.Repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchService {

    private final RoomRepository roomRepository ;

    public SearchResponse Search(SearchRequest request){

      List<Room> rooms =   roomRepository.findByHotelCityAndCapacity(request.getDestination() , request.getAdultsNumber()) ;

      return SearchResponse.builder()
              .Rooms(rooms)
              .build() ;

    }


}
