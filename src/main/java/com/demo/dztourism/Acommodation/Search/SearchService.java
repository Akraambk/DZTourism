package com.demo.dztourism.Acommodation.Search;


import com.demo.dztourism.Acommodation.Category.Category;
import com.demo.dztourism.Acommodation.Category.CategoryRepository;

import com.demo.dztourism.Acommodation.Model.Room;
import com.demo.dztourism.Acommodation.Repository.RoomRepository;
import com.demo.dztourism.Acommodation.Activity.Activity;
import com.demo.dztourism.Acommodation.Activity.ActivityRepository;
import com.demo.dztourism.Acommodation.Activity.ActivityRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SearchService {

    private final RoomRepository roomRepository ;

    private final ActivityRepository activityRepository ;

    private final CategoryRepository categoryRepository ;

    public SearchResponse SearchForRoom(SearchRequest request){

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

    public List<Activity> SearchForActivity(ActivityRequest request){

        Optional<Category> categoryOptional = categoryRepository.findById(request.getCategoryId());

        if (categoryOptional.isEmpty()) {
            throw new RuntimeException("category not found") ;
        }

        Category category = categoryOptional.get();

        return activityRepository.findByLocationAndCategoryAndDate(request.getLocation(), category, request.getDate()) ;

    }


    public List<Category> GetAllCategories(){

       return categoryRepository.findAll() ;

    }






}
