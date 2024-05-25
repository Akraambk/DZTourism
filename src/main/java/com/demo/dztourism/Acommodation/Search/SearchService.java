package com.demo.dztourism.Acommodation.Search;


import com.demo.dztourism.Acommodation.Category.Category;
import com.demo.dztourism.Acommodation.Category.CategoryRepository;

import com.demo.dztourism.Acommodation.Model.Hotel;
import com.demo.dztourism.Acommodation.Model.Room;
import com.demo.dztourism.Acommodation.Model.Room_Type;
import com.demo.dztourism.Acommodation.Repository.HotelRepository;
import com.demo.dztourism.Acommodation.Repository.RoomRepository;
import com.demo.dztourism.Acommodation.Activity.Activity;
import com.demo.dztourism.Acommodation.Activity.ActivityRepository;
import com.demo.dztourism.Acommodation.Activity.ActivityRequest;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
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
    private final HotelRepository hotelRepository ;

    private final ModelMapper modelMapper ;

//    public SearchResponse SearchForRoom(SearchRequest request){
//
//      List<Room> rooms =   roomRepository.findByHotelCityAndCapacity(request.getDestination() , request.getAdultsNumber()) ;
//
//      rooms.forEach( room -> {
//                  isAvailable(room, request.getCheckIn(), request.getCheckOut());
//              }
//      );
//
//
//      return SearchResponse.builder()
//              .Rooms(rooms)
//              .build() ;
//    }

    public void isAvailable(Room room , Date checkIn , Date checkOut) {

        if (roomRepository.isRoomAvailable(room.getID_Room(), checkIn, checkOut)){
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


    public SearchHotelResponse SearchRoomTypeByHotel(Long id_hotel , Date checkIn , Date checkOut) {

        Optional<Hotel> hotel = hotelRepository.findById(id_hotel) ;

        Hotel retrievedHotel = hotel.orElseThrow(()-> new RuntimeException("hotel not found ")) ;

        retrievedHotel
                .getRoom()
                .forEach(room -> isAvailable(room , checkIn , checkOut));

        return modelMapper.map(retrievedHotel , SearchHotelResponse.class);
    }
}
