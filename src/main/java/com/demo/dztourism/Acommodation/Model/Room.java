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
        name = "Rooms"
)
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID_Room ;

    private int Capacity ;

    private String Description ;

    private Boolean availability_status ;
    @ManyToOne
    @JoinColumn(
            name = "ID_Hotel"
    )
    private com.demo.dztourism.Acommodation.Model.Hotel Hotel ;


    @ManyToOne
    @JoinColumn(
            name = ("ID_Room_Type")
    )
    private com.demo.dztourism.Acommodation.Model.Room_Type Room_Type ;



    @ManyToMany(
            mappedBy = "Rooms" ,
            cascade = CascadeType.ALL
    )
    private List<Reservation> Reservations ;




}
