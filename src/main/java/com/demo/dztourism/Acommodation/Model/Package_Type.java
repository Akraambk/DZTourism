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
        name = "Package_Types"
)
public class Package_Type {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID_package_type ;

    private String Name ;

    private String Description ;

    private String Included_meals ;

    @ManyToMany(
            mappedBy = "Package_Type" ,
            cascade = CascadeType.ALL
    )
    private List<Reservation> Reservations ;




}
