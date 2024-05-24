package com.demo.dztourism.Acommodation.Model;

import com.demo.dztourism.Acommodation.Model.Amenity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
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
    private List<Room> Room;


    private String Bed_Type ;

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

    @ManyToOne
    @JoinColumn(
            name = "id_hotel"
    )
    @JsonIgnore
    private Hotel hotel ;
}
