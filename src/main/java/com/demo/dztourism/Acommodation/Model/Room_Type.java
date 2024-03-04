package com.demo.dztourism.Acommodation.Model;

import com.demo.dztourism.Acommodation.Model.Amenity;
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
        name = "Room_Types"
)
public class Room_Type {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID_Room_Type ;

    private String Name ;

    private String Description ;

    @OneToMany(
            mappedBy = "Room_Type" ,
            cascade = CascadeType.ALL
    )
    private List<com.demo.dztourism.Acommodation.Model.Room> Room;

   @ManyToMany(
           mappedBy = "Room_Type" ,
           cascade = CascadeType.ALL
   )
    private List<com.demo.dztourism.Acommodation.Model.Bed_Type> Bed_Type ;

    @ManyToMany
    @JoinTable(
            name = "Room_Types_Amenities" ,
            joinColumns = {
                    @JoinColumn (
                            name = "ID_Room_Type"
                    )
            } ,
            inverseJoinColumns = {
                    @JoinColumn(
                            name = "ID_Amenity"
                    )
            }
    )
    private List<Amenity> Amenities ;
}
