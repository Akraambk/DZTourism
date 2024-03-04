package com.demo.dztourism.Acommodation.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(
        name = "Reservations"
)
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID_Reservation ;

    private Date Check_In ;

    private Date Check_Out ;

    private int Adults_Number ;

    private int Children_Number ;

    private Boolean Reservation_status ;


    @ManyToMany
    @JoinTable(
            name = "Reservations_Rooms_Package_Types" ,
            joinColumns = {
                    @JoinColumn(
                            name = "ID_Reservation"
                    )
            } ,
            inverseJoinColumns = {
                    @JoinColumn(
                            name = "ID_Room"
                    )
            }
    )
    private List<Room> Rooms ;

    @ManyToMany
    @JoinTable(
            name = "Reservations_Rooms_Package_Types" ,
            joinColumns = {
                    @JoinColumn(
                            name = "ID_Reservation"
                    )
            },
            inverseJoinColumns = {
                    @JoinColumn(
                            name = "ID_package_type"
                    )
            }
    )
    private List<com.demo.dztourism.Acommodation.Model.Package_Type> Package_Type ;


}
