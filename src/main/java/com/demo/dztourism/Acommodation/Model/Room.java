package com.demo.dztourism.Acommodation.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Optional;

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

    private int Room_number ;

    private String Description ;

    private Boolean availability_status ;
    @ManyToOne
    @JoinColumn(
            name = "ID_Hotel"
    )
    @JsonIgnore
    private Hotel Hotel ;



    @ManyToOne
    @JoinColumn(
            name = ("ID_Room_Type")
    )
    @JsonIgnore
    private Room_Type Room_Type ;



    @ManyToMany(
            mappedBy = "Rooms" ,
            cascade = CascadeType.ALL
    )
    private List<Reservation> Reservations ;




}
