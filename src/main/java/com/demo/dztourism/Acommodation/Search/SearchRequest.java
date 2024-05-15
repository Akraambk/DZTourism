package com.demo.dztourism.Acommodation.Search;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.NumberFormat;

import java.util.Date;

@Builder
@Getter
@Setter
public class SearchRequest {

    @NotEmpty(message = "destination is mandatory")
    @NotBlank(message = "destination is mandatory")
    private String destination ;

//    @NotEmpty(message = "checkIn is mandatory")
//    @NotBlank(message = "checkIn is mandatory")
    private Date checkIn ;

//    @NotEmpty(message = "checkOut is mandatory")
//    @NotBlank(message = "checkOut is mandatory")
    private Date checkOut ;

//  @NotEmpty(message = "adultsNumber is mandatory")
//   @NotBlank(message = "adultsNumber is mandatory")
    private int adultsNumber ;

//    @NotEmpty(message = "childrenNumber is mandatory")
//    @NotBlank(message = "childrenNumber is mandatory")
    private int childrenNumber ;

//    @NotEmpty(message = "nbrRooms is mandatory")
//    @NotBlank(message = "nbrRooms is mandatory")
    private int nbrRooms ;

}
