package com.demo.dztourism.Acommodation.Authentication;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class AuthenticationRequest {

    @NotEmpty(message = "email is mandatory")
    @NotNull(message = "email is mandatory")
    @Email(message = "Email is mandatory")
    private String email ;

    @NotEmpty(message = "password is mandatory")
    @NotNull(message = "password is mandatory")
    @Size(min = 8 , message = "the password should ne minimum composed of 8 characters")
    private String password ;



}
