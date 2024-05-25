package com.demo.dztourism.Acommodation.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(
        name = "Hotels"
)
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID_Hotel ;

    private String Name ;

    private String Phone_number ;

    private String Email ;

    private int Star_Rating ;

    private String Description ;

    private String Street_Address ;

    private String city ;

    private Double Postal_Code ;

    private String Country ;

    private Double Latitude ;

    private Double Longitude ;

    private String Timezone ;

    private String Photos ;

    @OneToMany(
            mappedBy = "hotel" ,
            cascade = CascadeType.ALL )
    private List<Room> Room;

    @OneToMany(
            mappedBy = "hotel" ,
            cascade = CascadeType.ALL )
    private List<Room_Type> room_type ;
}
