package com.demo.dztourism.Acommodation.Model;

import com.demo.dztourism.Acommodation.User.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @ManyToOne
    @JoinColumn(
            name = "ID_Bill"
    )
    private Bill bill ;

    @ManyToOne
    @JoinColumn(
            name = "ID"
    )
    @JsonIgnore
    private User client ;


   @ManyToOne
   @JoinColumn(
           name = "ID_Room"
   )
    private Room room ;

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
