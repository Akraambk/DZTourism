package com.demo.dztourism.Acommodation.Authentication;

import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Builder
@Getter
@Setter
public class RegistrationRequest {

    @NotEmpty(message = "FirstName is mandatory")
    @NotNull(message = "FirstName is mandatory")
    private String firstName ;

    @NotEmpty(message = "lastName is mandatory")
    @NotNull(message = "LastName is mandatory")
    private String lastName ;

    @NotEmpty(message = "email is mandatory")
    @NotNull(message = "email is mandatory")
    @Email
    private String email ;

    @NotEmpty(message = "password is mandatory")
    @NotNull(message = "password is mandatory")
    @Size(min = 8 , message = "the password should ne minimum composed of 8 characters")
    private String password ;


}
