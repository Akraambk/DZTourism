package com.demo.dztourism.Acommodation.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(
        name = "Amenities"
)
public class Amenity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID_Amenity ;

    private String Name ;

    private String Description ;

   @ManyToMany(
           mappedBy = "Amenities" ,
           cascade = CascadeType.ALL
   )
    private List<Room_Type> Room_type ;
}
