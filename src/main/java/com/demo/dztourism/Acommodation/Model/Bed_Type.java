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
        name = "Bed_Types"
)
public class Bed_Type {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID_Bed_Type ;

    private String Name ;

    private String Description ;

   @ManyToMany
   @JoinTable(
           name = "Bed_Type_Room_Type" ,
           joinColumns = {
                   @JoinColumn(
                           name = "ID_Bed_Type"
                   )
           } ,
           inverseJoinColumns = {
                   @JoinColumn (
                           name = "ID_Room_Type"
                   )
           }
   )
    private List<com.demo.dztourism.Acommodation.Model.Room_Type> Room_Type ;
}
