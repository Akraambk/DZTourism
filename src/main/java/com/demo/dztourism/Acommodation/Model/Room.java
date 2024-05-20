package com.demo.dztourism.Acommodation.Model;


import com.demo.dztourism.Acommodation.Booking.BookingRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(
        name = "Rooms"
)
@Getter
@Setter
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roomId ;

    private int capacity ;

    private int Room_number ;

    private String Description ;

    private Boolean availability_status ;
    @ManyToOne
    @JoinColumn(
            name = "ID_Hotel"
    )
    @JsonIgnore
    private Hotel hotel ;



    @ManyToOne
    @JoinColumn(
            name = ("ID_Room_Type")
    )
    @JsonIgnore
    private Room_Type Room_Type ;



    @OneToMany(
            mappedBy = "room" ,
            cascade = CascadeType.ALL
    )
    @JsonIgnore
    private List<Reservation> reservation ;

}
