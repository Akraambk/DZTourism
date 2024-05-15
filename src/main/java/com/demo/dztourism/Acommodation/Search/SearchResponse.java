package com.demo.dztourism.Acommodation.Search;

import com.demo.dztourism.Acommodation.Model.Room;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter
public class SearchResponse {

    List<Room> Rooms ;

}
